import React from 'react';
import './App.css';
import PostList from '/PostList';
import CreatePost from '/CreatePost';

function App() {
return (
    <div className="App">
    <h1>Blog App</h1>
    <CreatePost />
    <PostList />
    </div>
    );
}

export default App;
