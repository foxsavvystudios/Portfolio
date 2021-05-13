import { AUTHENTICATED, NOT_AUTHENTICATED } from '.'

const setToken = (token) => {
    localStorage.setItem('token', token)
    localStorage.setItem('lastLoginTime', new Date(Date.now()).getTime())
}

const getToken = () => {
    const now = new Date(Date.now()).getTime()
    const thirtyMinutes = 1000 * 60 * 30
    const timeSinceLastLogin = now - localStorage.getItem('lastLoginTime')

    if (timeSinceLastLogin < thirtyMinutes) {
        return localStorage.getItem('token')
    }
}

export const signupUser = (credentials) => {
    return (dispatch) => {
        return fetch('', {
            method: 'POST',
            headers: {
                Accept: 'application/json',
                'Content-type': 'application/json'
            },
            body: JSON.stringify({ user: credentials })
        }).then((resp) => {
            if (resp.ok) {
                setToken(resp.headers.get('Authorization'))
                return resp.json()
                        .then((userJSON) => 
                                dispatch({ type: AUTHENTICATED, payload: userJSON })
                                )
            }
            else {
                return resp.json().then((errors) => {
                    dispatch({ type: NOT_AUTHENTICATED})
                    return Promise.reject(errors)
                })
            }
        })
    }
}

export const loginUser = (credentials) => {
    return (dispatch) => {
        return fetch('', {
            method: 'POST',
            headers: {
                Accept: 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ user: credentials })
        }).then((resp) => {
            if (resp.ok) {
                setToken(resp.headers.get('Authorization'))
                return resp.json()
                        .then((userJSON) =>
                                dispatch({ type: AUTHENTICATED, payload: userJSON })
                                )
            }
            else {
                return resp.json().then((errors) => {
                    dispatch({ type: NOT_AUTHENTICATED })
                    return Promise.reject(errors)
                })
            }
        })
    }
}

export const logoutUser = () => {
    return (dispatch) => {
        return fetch('', {
            method: 'DELETE',
            headers: {
                Accept: 'application/json',
                'Content-type': 'application/json',
                Authorization: getToken()
            }
        }).then((resp) => {
            if (resp.ok) {
                return dispatch({ type: NOT_AUTHENTICATED })
            }
            else {
                return resp.json().then((errors) => {
                    dispatch({ type: NOT_AUTHENTICATED })
                    return Promise.reject(errors)
                })
            }
        })
    }
}