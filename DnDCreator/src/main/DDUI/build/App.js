import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import PostList from './components/Blog/PostList'

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <PostList />    
      </header>
    </div>
  );
}

export default App
