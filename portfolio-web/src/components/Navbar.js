import React from 'react'
import { NavLink } from 'react-router-dom'
import profile from '../Me.jpg'
import Logout from './auth/Logout'



class Navbar extends React.Component {

    constructor(props) {
        super(props)

        this.state={
            pages: [{
                name: '',
                d: '',
                route: ''
            }],
            open: false
        }

    }

    handleClick = (event) => {
        event.preventDefault()
         
        if (event.currentTarget.id === 'open'){
            this.setState({
                open: true
            })
        }else if (event.currentTarget.id === 'close'){
            this.setState({
                open: false
            })
        }
    }
    
    handleSubmit = (event) => {
        event.preventDefault()

        if((this.state.pages.name === '') || (this.state.pages.d === '') || (this.state.pages.route === '')){
            this.setState({
                pages: [
                    {
                        name: event.target.name.value,
                        d: event.target.icon.value,
                        route: event.target.route.value
                    }],
                    open: false
            })
        } else{
            this.setState({
            
                pages: [
                    ...this.state.pages,
                    {
                        name: event.target.name.value,
                        d: event.target.icon.value,
                        route: event.target.route.value
                    }],
                    open: false
            })
        }
    }

    render(){
        return (
            <div>
                <nav className='w-64 h-full flex-shrink-0'>
                    <div className="flex-auto top-0 left-0 bg-gray-900 h-full shadow-lg">
                        <div className="flex overflow-y-auto items-center pl-6 h-20 border-b border-gray-800">
                            <img src={profile} alt="Sean Bordelon" className="rounded-full h-10 w-10 flex items-center justify-center mr-3 border-2 border-blue-500"/>
                            <div className="ml-1">
                                <p className="ml-1 text-md font-medium tracking-wide truncate text-gray-100 font-sans">SEAN BORDELON</p>
                                <div className="badge">
                                    <span className="px-2 py-0.5 ml-auto text-xs font-medium tracking-wide text-blue-800 bg-blue-100 rounded-full">Admin</span>
                                </div>
                            </div>
                        </div>
                        <div className="overflow-y-auto overflow-x-hidden flex-grow">
                            <ul className="flex flex-col py-6 space-y-1">
                                <section>
                                <li className="px-5">
                                    <div className="flex flex-row items-center h-8">
                                        <div className="flex font-semibold text-sm text-gray-300 my-4 font-sans uppercase">Dashboard</div>
                                        <button id='open' onClick={this.handleClick} className="ml-24 mb-1 w-8 h-8 active:shadow-lg mouse shadow transition ease-in duration-200 focus:outline-none">
                                            <svg viewBox="0 0 20 20" enableBackground="new 0 0 20 20" className="w-6 h-6 inline-block">
                                                <path fill="#FFFFFF" d="M16,10c0,0.553-0.048,1-0.601,1H11v4.399C11,15.951,10.553,16,10,16c-0.553,0-1-0.049-1-0.601V11H4.601
                                                    C4.049,11,4,10.553,4,10c0-0.553,0.049-1,0.601-1H9V4.601C9,4.048,9.447,4,10,4c0.553,0,1,0.048,1,0.601V9h4.399
                                                    C15.952,9,16,9.447,16,10z" />
                                            </svg>
                                        </button>
                                    </div>
                                </li>
                                {this.state.pages.map((page) => (page.name == '') || (page.d == '') || (page.route == '') ? null :
                                (<li>
                                   <NavLink
                                        className="relative flex flex-row items-center h-11 focus:outline-none hover:bg-gray-700 text-gray-500 hover:text-gray-200 border-l-4 border-transparent hover:border-blue-500 pr-6"
                                        activeClassName='text-red-500'
                                        exact
                                        to={page.route}
                                    >
                                        <span className="inline-flex justify-center items-center ml-4">
                                            <svg className="w-5 h-5" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path strokeLinecap="round" strokeLinejoin="round" stroke-width="2" d={page.d}></path></svg>
                                        </span>
                                        <span className="ml-2 font-semibold text-sm tracking-wide truncate font-sans">{page.name}</span>
                                    </NavLink>
                                </li>))}
                                </section>
                                <section>
                                    <li className="px-5">
                                        <div className="flex flex-row items-center h-8">
                                            <div className="flex font-semibold text-sm text-gray-300 my-4 font-sans uppercase">Settings</div>
                                        </div>
                                    </li>
                                    <li>
                                        <a href="#" className="relative flex flex-row items-center h-11 focus:outline-none hover:bg-gray-700 text-gray-500 hover:text-gray-200 border-l-4 border-transparent hover:border-blue-500 pr-6">
                                            <span className="inline-flex justify-center items-center ml-4">
                                                <svg className="w-5 h-5" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path strokeLinecap="round" strokeLinejoin="round" stroke-width="2" d="M16 7a4 4 0 11-8 0 4 4 0 018 0zM12 14a7 7 0 00-7 7h14a7 7 0 00-7-7z"></path></svg>
                                            </span>
                                            <span className="ml-2 font-semibold text-sm tracking-wide truncate font-sans">Profile</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#" className="relative flex flex-row items-center h-11 focus:outline-none hover:bg-gray-700 text-gray-500 hover:text-gray-200 border-l-4 border-transparent hover:border-blue-500 pr-6">
                                            <span className="inline-flex justify-center items-center ml-4">
                                                <svg className="w-5 h-5" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
                                                    <path strokeLinecap="round" strokeLinejoin="round" stroke-width="2" d="M10.325 4.317c.426-1.756 2.924-1.756 3.35 0a1.724 1.724 0 002.573 1.066c1.543-.94 3.31.826 2.37 2.37a1.724 1.724 0 001.065 2.572c1.756.426 1.756 2.924 0 3.35a1.724 1.724 0 00-1.066 2.573c.94 1.543-.826 3.31-2.37 2.37a1.724 1.724 0 00-2.572 1.065c-.426 1.756-2.924 1.756-3.35 0a1.724 1.724 0 00-2.573-1.066c-1.543.94-3.31-.826-2.37-2.37a1.724 1.724 0 00-1.065-2.572c-1.756-.426-1.756-2.924 0-3.35a1.724 1.724 0 001.066-2.573c-.94-1.543.826-3.31 2.37-2.37.996.608 2.296.07 2.572-1.065z"></path>
                                                    <path strokeLinecap="round" strokeLinejoin="round" stroke-width="2" d="M15 12a3 3 0 11-6 0 3 3 0 016 0z"></path>
                                                </svg>
                                            </span>
                                            <span className="ml-2 font-semibold text-sm tracking-wide truncate font-sans">Settings</span>
                                        </a>
                                    </li>
                                    <li>
                                        <Logout />
                                    </li>
                                </section>
                            </ul>
                        </div>
                    </div>
                </nav>
                {this.state.open ? (
                    <div class="main-modal fixed w-full h-100 inset-0 z-50 overflow flex justify-center items-center"
                    style={{backgroundColor: 'rgba(0,0,0,.7)'}}>
                    <div
                        class="border border-teal-500 shadow-lg modal-container bg-white w-11/12 md:max-w-md mx-auto rounded shadow-lg z-50 overflow-y-auto">
                        <div class="modal-content py-4 text-left px-6">
                            <div class="flex justify-between items-center pb-3">
                                <p class="text-2xl font-bold">Header</p>
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
                                    <div class='flex mb-2'>
                                        <span class="text-sm border border-2 rounded-l px-4 py-2 bg-gray-300 whitespace-no-wrap">Page Neme:</span>
                                        <input className='border border-2 rounded-r px-4 py-2 w-full' type='text' id='name' name='name' placeholder='Home'/>
                                    </div>

                                    <div class='flex mb-2'>
                                        <span class="text-sm border border-2 rounded-l px-4 py-2 bg-gray-300 whitespace-no-wrap">Icon:</span>
                                        <input className='border border-2 rounded-r px-4 py-2 w-full' type='textarea' id='icon' name='icon' placeholder="Dimensions"/>
                                    </div>

                                    <div class='flex mb-2'>
                                        <span class="text-sm border border-2 rounded-l px-4 py-2 bg-gray-300 whitespace-no-wrap">Route:</span>
                                        <input className='border border-2 rounded-r px-4 py-2 w-full' type='text' id='route' name='route' placeholder="/login"/>
                                    </div>
                                    
                                    <div class='mt-2'>
                                    <button id='close' onClick={this.handleClick}
                                        class="focus:outline-none modal-close px-4 bg-gray-400 p-3 rounded-lg text-black hover:bg-gray-300">Cancel</button>
                                    <button type='submit'
                                        class="focus:outline-none px-4 bg-teal-500 p-3 ml-3 rounded-lg text-white hover:bg-teal-400">Confirm</button>
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

export default Navbar