import React from 'react'
import Navbar from './Navbar'


class Artist extends React.Component {

    state = {
        open: false,
        modalType: ''
    }

    handleClick = (event) => {
        event.preventDefault();

    
        if(event.currentTarget.className.includes('add-modal')) {
            this.setState({
                modalType: 'Add'
            })
        }else if (event.currentTarget.className.includes('edit-modal')) {
            this.setState({
                modalType: 'Edit'
            })
        }

        if(event.currentTarget.id === 'open'){
            this.setState({
                open: true
            })
        } else if (event.currentTarget.id === 'close') {
            this.setState({
                open: false
            })
        }
    }

    render() {
        return(
            <div class='flex min-h-screen'>
                <Navbar />
                <div className='flex flex-col w-full'>
                    <header className='flex justify-end bg-blue-300 p-2'>
                        <form>
                            <input onChange={this.handleChange} className='rounded-l-md pl-2' type='text' value='search' placeholder='Search'/>
                            <button className='w-20 px-2 rounded-r-md bg-yellow-400' type='submit' value='Search'>Search</button>
                        </form>
                    </header>
                    <div class="relative overflow-x-auto">
                        <div class="min-w-screen min-h-screen bg-gray-100 flex items-center justify-center bg-gray-100 font-sans overflow-hidden">
                            <div class="w-full lg:w-5/6">
                                <button id='open' onClick={this.handleClick} class="add-modal bg-blue-300 text-white font-bold py-2 px-4 border-b-4 hover:border-b-2 hover:border-t-2 border-blue-500 hover:border-blue-300 rounded">
                                    Add Artist
                                </button>
                                <div class="bg-white shadow-md rounded my-6">
                                    <table class="min-w-max w-full table-auto">
                                        <thead>
                                            <tr class="bg-gray-200 text-gray-600 uppercase text-sm leading-normal">
                                                <th class="py-3 px-6 text-left"></th>
                                                <th class="py-3 px-6 text-left">Artist</th>
                                                <th class="py-3 px-6 text-center">Portfolios</th>
                                                <th class="py-3 px-6 text-center">Status</th>
                                                <th class="py-3 px-6 text-center">Actions</th>
                                            </tr>
                                        </thead>
                                        <tbody class="text-gray-600 text-sm font-light">
                                            <tr class="border-b border-gray-200 hover:bg-gray-100">
                                                <td class="py-3 px-6 whitespace-nowrap">
                                                    <div class="flex justify-center">
                                                        <label class="inline-flex items-center">
                                                            <input type="checkbox" class="form-checkbox h-5 w-5 text-blue-600" checked />
                                                        </label>
                                                    </div>
                                                </td>
                                                <td class="py-3 px-6 text-left">
                                                    <div class="flex items-center">
                                                        <div class="mr-2">
                                                            <img class="w-6 h-6 rounded-full" src="https://randomuser.me/api/portraits/men/1.jpg"/>
                                                        </div>
                                                        <span>Eshal Rosas</span>
                                                    </div>
                                                </td>
                                                <td class="py-3 px-6 text-center">
                                                    <div class="flex items-center justify-center">
                                                        <img class="w-6 h-6 rounded-full border-gray-200 border transform hover:scale-125" src="https://randomuser.me/api/portraits/men/1.jpg"/>
                                                        <img class="w-6 h-6 rounded-full border-gray-200 border -m-1 transform hover:scale-125" src="https://randomuser.me/api/portraits/women/2.jpg"/>
                                                        <img class="w-6 h-6 rounded-full border-gray-200 border -m-1 transform hover:scale-125" src="https://randomuser.me/api/portraits/men/3.jpg"/>
                                                    </div>
                                                </td>
                                                <td class="py-3 px-6 text-center">
                                                    <span class="bg-purple-200 text-purple-600 py-1 px-3 rounded-full text-xs">Active</span>
                                                </td>
                                                <td class="py-3 px-6 text-center">
                                                    <div class="flex item-center justify-center">
                                                        <div class="w-4 mr-2 transform hover:text-purple-500 hover:scale-110">
                                                            <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                                                                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M15 12a3 3 0 11-6 0 3 3 0 016 0z" />
                                                                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M2.458 12C3.732 7.943 7.523 5 12 5c4.478 0 8.268 2.943 9.542 7-1.274 4.057-5.064 7-9.542 7-4.477 0-8.268-2.943-9.542-7z" />
                                                            </svg>
                                                        </div>
                                                        <div class="w-4 mr-2 transform hover:text-purple-500 hover:scale-110">
                                                            <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                                                                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M15.232 5.232l3.536 3.536m-2.036-5.036a2.5 2.5 0 113.536 3.536L6.5 21.036H3v-3.572L16.732 3.732z" />
                                                            </svg>
                                                        </div>
                                                        <div class="w-4 mr-2 transform hover:text-purple-500 hover:scale-110">
                                                            <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                                                                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M19 7l-.867 12.142A2 2 0 0116.138 21H7.862a2 2 0 01-1.995-1.858L5 7m5 4v6m4-6v6m1-10V4a1 1 0 00-1-1h-4a1 1 0 00-1 1v3M4 7h16" />
                                                            </svg>
                                                        </div>
                                                    </div>
                                                </td>
                                            </tr>
                                            <tr class="border-b border-gray-200 bg-gray-50 hover:bg-gray-100">
                                                <td class="py-3 px-6">
                                                    <div class="flex justify-center">
                                                        <label class="inline-flex items-center">
                                                            <input type="checkbox" class="form-checkbox h-5 w-5 text-blue-600" checked />
                                                        </label>
                                                    </div>
                                                </td>
                                                <td class="py-3 px-6 text-left">
                                                    <div class="flex items-center">
                                                        <div class="mr-2">
                                                            <img class="w-6 h-6 rounded-full" src="https://randomuser.me/api/portraits/women/2.jpg"/>
                                                        </div>
                                                        <span>Anita Rodriquez</span>
                                                    </div>
                                                </td>
                                                <td class="py-3 px-6 text-center">
                                                    <div class="flex items-center justify-center">
                                                        <img class="w-6 h-6 rounded-full border-gray-200 border transform hover:scale-125" src="https://randomuser.me/api/portraits/men/1.jpg"/>
                                                        <img class="w-6 h-6 rounded-full border-gray-200 border -m-1 transform hover:scale-125" src="https://randomuser.me/api/portraits/women/2.jpg"/>
                                                        <img class="w-6 h-6 rounded-full border-gray-200 border -m-1 transform hover:scale-125" src="https://randomuser.me/api/portraits/men/3.jpg"/>
                                                    </div>
                                                </td>
                                                <td class="py-3 px-6 text-center">
                                                    <span class="bg-green-200 text-green-600 py-1 px-3 rounded-full text-xs">Completed</span>
                                                </td>
                                                <td class="py-3 px-6 text-center">
                                                    <div class="flex item-center justify-center">
                                                        <div class="w-4 mr-2 transform hover:text-purple-500 hover:scale-110">
                                                            <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                                                                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M15 12a3 3 0 11-6 0 3 3 0 016 0z" />
                                                                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M2.458 12C3.732 7.943 7.523 5 12 5c4.478 0 8.268 2.943 9.542 7-1.274 4.057-5.064 7-9.542 7-4.477 0-8.268-2.943-9.542-7z" />
                                                            </svg>
                                                        </div>
                                                        <div class="w-4 mr-2 transform hover:text-purple-500 hover:scale-110">
                                                            <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                                                                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M15.232 5.232l3.536 3.536m-2.036-5.036a2.5 2.5 0 113.536 3.536L6.5 21.036H3v-3.572L16.732 3.732z" />
                                                            </svg>
                                                        </div>
                                                        <div class="w-4 mr-2 transform hover:text-purple-500 hover:scale-110">
                                                            <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                                                                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M19 7l-.867 12.142A2 2 0 0116.138 21H7.862a2 2 0 01-1.995-1.858L5 7m5 4v6m4-6v6m1-10V4a1 1 0 00-1-1h-4a1 1 0 00-1 1v3M4 7h16" />
                                                            </svg>
                                                        </div>
                                                    </div>
                                                </td>
                                            </tr>
                                            <tr class="border-b border-gray-200 hover:bg-gray-100">
                                                <td class="py-3 px-6">
                                                    <div class="flex justify-center">
                                                        <label class="inline-flex items-center">
                                                            <input type="checkbox" class="form-checkbox h-5 w-5 text-blue-600" checked />
                                                        </label>
                                                    </div>
                                                </td>
                                                <td class="py-3 px-6 text-left">
                                                    <div class="flex items-center">
                                                        <div class="mr-2">
                                                            <img class="w-6 h-6 rounded-full" src="https://randomuser.me/api/portraits/men/3.jpg"/>
                                                        </div>
                                                        <span>Taylan Bush</span>
                                                    </div>
                                                </td>
                                                <td class="py-3 px-6 text-center">
                                                    <div class="flex items-center justify-center">
                                                        <img class="w-6 h-6 rounded-full border-gray-200 border transform hover:scale-125" src="https://randomuser.me/api/portraits/men/1.jpg"/>
                                                        <img class="w-6 h-6 rounded-full border-gray-200 border -m-1 transform hover:scale-125" src="https://randomuser.me/api/portraits/women/2.jpg"/>
                                                        <img class="w-6 h-6 rounded-full border-gray-200 border -m-1 transform hover:scale-125" src="https://randomuser.me/api/portraits/men/3.jpg"/>
                                                    </div>
                                                </td>
                                                <td class="py-3 px-6 text-center">
                                                    <span class="bg-yellow-200 text-yellow-600 py-1 px-3 rounded-full text-xs">Scheduled</span>
                                                </td>
                                                <td class="py-3 px-6 text-center">
                                                    <div class="flex item-center justify-center">
                                                        <div class="w-4 mr-2 transform hover:text-purple-500 hover:scale-110">
                                                            <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                                                                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M15 12a3 3 0 11-6 0 3 3 0 016 0z" />
                                                                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M2.458 12C3.732 7.943 7.523 5 12 5c4.478 0 8.268 2.943 9.542 7-1.274 4.057-5.064 7-9.542 7-4.477 0-8.268-2.943-9.542-7z" />
                                                            </svg>
                                                        </div>
                                                        <button id='open' onClick={this.handleClick} class="edit-modal">
                                                        <div class="w-4 mr-2 transform hover:text-purple-500 hover:scale-110">
                                                            
                                                                <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                                                                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M15.232 5.232l3.536 3.536m-2.036-5.036a2.5 2.5 0 113.536 3.536L6.5 21.036H3v-3.572L16.732 3.732z" />
                                                                </svg>
                                                           
                                                        </div>
                                                        </button>      
                                                        <div class="w-4 mr-2 transform hover:text-purple-500 hover:scale-110">
                                                            <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                                                                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M19 7l-.867 12.142A2 2 0 0116.138 21H7.862a2 2 0 01-1.995-1.858L5 7m5 4v6m4-6v6m1-10V4a1 1 0 00-1-1h-4a1 1 0 00-1 1v3M4 7h16" />
                                                            </svg>
                                                        </div>
                                                    </div>
                                                </td>
                                            </tr>            
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                {this.state.open ? (
                    <div class="main-modal fixed w-full h-100 inset-0 z-50 overflow flex justify-center items-center"
                    style={{backgroundColor: 'rgba(0,0,0,.7)'}}>
                    <div
                        class="border border-teal-500 shadow-lg modal-container bg-white w-11/12 md:max-w-md mx-auto rounded shadow-lg z-50 overflow-y-auto">
                        <div class="modal-content py-4 text-left px-6">
                            <div class="flex justify-between items-center pb-3">
                                <p class="text-2xl font-bold">{this.state.modalType} Artist</p>
                                <button type="button" id='close' onClick={this.handleClick}>
                                    <div class="modal-close cursor-pointer z-50">
                                        <svg class="fill-current text-black" xmlns="http://www.w3.org/2000/svg" width="18" height="18"
                                            viewBox="0 0 18 18">
                                            <path
                                                d="M14.53 4.53l-1.06-1.06L9 7.94 4.53 3.47 3.47 4.53 7.94 9l-4.47 4.47 1.06 1.06L9 10.06l4.47 4.47 1.06-1.06L10.06 9z">
                                            </path>
                                        </svg>
                                    </div>
                                </button>
                            </div>
                            <div class="my-5">
                                <form className='m-4 flex flex-col' onSubmit={this.handleSubmit}>                           
                                    <div class="-mx-3 md:flex mb-6">
                                        <div class="md:w-1/2 px-3 mb-6 md:mb-0">
                                            <label class="block uppercase tracking-wide text-grey-darker text-xs font-bold mb-2" for="first_name">
                                                First Name
                                            </label>
                                            <input class="appearance-none block w-full bg-grey-lighter text-grey-darker border border-red rounded py-3 px-4 mb-3" id="first_name" name='first_name' type="text" placeholder="Jane" />
                                            <p class="text-red text-xs italic">Please fill out this field.</p>
                                        </div>
                                        <div class="md:w-1/2 px-3">
                                            <label class="block uppercase tracking-wide text-grey-darker text-xs font-bold mb-2" for="last_name">
                                                Last Name
                                            </label>
                                            <input class="appearance-none block w-full bg-grey-lighter text-grey-darker border border-grey-lighter rounded py-3 px-4" id="last_name" name='last_name' type="text" placeholder="Doe" />
                                        </div>
                                    </div>
                                    <div class="-mx-3 md:flex mb-6">
                                        <div class="md:w-full px-3">
                                            <label class="block uppercase tracking-wide text-grey-darker text-xs font-bold mb-2" for="display_name">
                                                Display Name
                                            </label>
                                            <input class="appearance-none block w-full bg-grey-lighter text-grey-darker border border-grey-lighter rounded py-3 px-4 mb-3" id="display_name" name='display_name' type="text" placeholder="tatguy187" />
                                            <p class="text-grey-dark text-xs italic">Make it as long and as crazy as you'd like</p>
                                        </div>
                                    </div>
                                    <div class="py-3 center mx-auto">
                                        <div class="bg-white px-4 py-5 rounded-lg shadow-lg text-center w-48">
                                            <div class="mb-4">
                                                <img class="w-auto mx-auto rounded-full object-cover object-center" src="https://i1.pngguru.com/preview/137/834/449/cartoon-cartoon-character-avatar-drawing-film-ecommerce-facial-expression-png-clipart.jpg" alt="Avatar Upload" />
                                            </div>
                                            <label class="cursor-pointer mt-6">
                                                <span class="mt-2 text-base leading-normal px-4 py-2 bg-blue-500 text-white text-sm rounded-full" >Select Avatar</span>
                                                <input type='file' class="hidden" multiple="multiple" accept="accept" />
                                            </label>
                                        </div>
                                    </div>
                                    <div class='mt-2'>
                                        <button id='close' onClick={this.handleClick}
                                            class="focus:outline-none modal-close px-4 bg-gray-400 p-3 rounded-lg text-black hover:bg-gray-300">Cancel</button>
                                        <button type='submit'
                                            class="focus:outline-none px-4 bg-teal-500 p-3 ml-3 rounded-lg text-white hover:bg-teal-400">{this.state.modalType}</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                ) : null }
            </div>
        )
    }
}

export default Artist