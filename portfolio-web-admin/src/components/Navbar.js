import React from 'react'
import { NavLink } from 'react-router-dom'
import profile from '../Me.jpg'
import Logout from './auth/Logout'
import { ImHome, ImFolderOpen } from 'react-icons/im'
import { FaPaintBrush } from 'react-icons/fa'

const links = [
    {
        name: 'Home',
        icon: <ImHome />,
        route: '/'
    },
    {
        name: 'Artists',
        icon: <FaPaintBrush />,
        route: '/artist'
    },
    {
        name: 'Portfolios',
        icon: <ImFolderOpen />,
        route: '/portfolio'
    }
]

class Navbar extends React.Component {
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
                                    </div>
                                </li>
                                {links.map((link) => 
                                (<li>
                                   <NavLink
                                        className="relative flex flex-row items-center h-11 focus:outline-none hover:bg-gray-700 text-gray-500 hover:text-gray-200 border-l-4 border-transparent hover:border-blue-500 pr-6"
                                        activeClassName='text-red-500'
                                        exact
                                        to={link.route}
                                    >
                                        <span className="inline-flex justify-center items-center ml-4">
                                            {link.icon}
                                        </span>
                                        <span className="ml-2 font-semibold text-sm tracking-wide truncate font-sans">{link.name}</span>
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
            </div>
        )
    }
}

export default Navbar