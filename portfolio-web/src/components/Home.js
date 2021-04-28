import React from 'react'
import Navbar from './Navbar'

class Home extends React.Component {
    render(){
        return(
            <div className="flex min-h-screen">  
                <Navbar />
                <div className='flex flex-col w-full'>
                <header className='flex justify-end bg-blue-300 p-2'>
            <form>
              <input className='rounded-lg pl-2 mr-2' type='text' value='' placeholder='Search'/>
              <button className='w-20 px-2 rounded-md bg-yellow-400' type='submit' value='Search'>Search</button>
            </form>
          </header>
                <div className='text-center'>
                    Welcome!
                </div>
                </div>
                </div>
        )
    }
}


export default Home