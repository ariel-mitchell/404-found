import React, { useState, useEffect } from "react";
import axios from "axios";

function CreatePost () {
    const [post, setPost] = useState({ title: '', content: '', author: '',});

    const handleSubmit = async (e) => {
        e.preventDeault();
        try {
            const response = await axios.post('http://localhost:5173/posts/create', post);
            console.log('Post created:', response.data);
        } catch (error) {
            console.error('Error creating post:', error);
        }
    };

    const handleChange = (e) => {
        setPost({ post, [e.target.name]: e.target.value });
    };
return (
    <div>
        <h2>Create Post</h2>
        <form onSubmit={handleSubmit}>
            <label>Title:
                <input type="text" name="title" value={post.title} onChange={handleChange} />
            </label>
            <label>Content:
                <textarea name="content" value={post.content} onChange={handleChange} />
            </label>
            <label>Author:
                <input type="text" name="author" value={post.author} onChange={handleChange} />
            </label>
                <button type="submit">Create Post</button>
        </form>
    </div>
    );
}

export default CreatePost;
