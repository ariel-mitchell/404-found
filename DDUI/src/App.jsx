import React from 'react';
import './App.css';
import PostList from '@/BlogComponents/PostList';
import CreatePost from '@/BlogComponents/CreatePost';

function App() {
return (
    <div className="App">
    <h1>DnD Blog</h1>
    <CreatePost />
    </div>
);
}

export default App;
