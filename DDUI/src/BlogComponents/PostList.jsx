import React, { useState, useEffect } from 'react';
import axios from 'axios';

function PostList() {
    const [posts, setPosts] = useState([]);

    useEffect(() => {
        axios.get('http://localhost:5173/posts')
        .then(response => {
            console.log('API Response:', response.data);
            setPosts(response.data);
        })
        .catch(error => console.error('Error fetching posts:', error));
    }, []);

    return (
        <div>
        <h2>Posts</h2>
        <ul>
            {Array.isArray(posts) && posts.map(post => (
            <li key={post.id}>
                {post.title} - {post.author}
            </li>
            ))}
        </ul>
        </div>
    );
}

export default PostList;
