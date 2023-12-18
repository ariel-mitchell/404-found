import React from 'react';
import './App.css';
import "./BlogComponents";
import PostList from './BlogComponents/PostLists';
import CreatePost from './BlogComponents/CreatePost';

function App() {
    return (
    <div className="App container">
        <h1>Blog App</h1>
        <CreatePost className="create-post-form" />
        <PostList className="post-list" />
    </div>
    );
}

export default App;
