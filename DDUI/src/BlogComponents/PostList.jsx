import React, { useState, useEffect } from 'react';
import axios from 'axios';
import Post from './Post';

function PostList() {
const [posts, setPosts] = useState([]);

useEffect(() => {
    const fetchPosts = async () => {
    try {
        const response = await axios.get('http://localhost:8080/api/posts');
        console.log('API Response:', response.data);
        setPosts(response.data);
    } catch (error) {
        console.error('Error fetching posts:', error);
    }
    };

    fetchPosts();
}, []);

return (
    <div>
    <h2>Posts</h2>
    <ul>
        {Array.isArray(posts) && posts.map(post => (
        <Post key={post.id} post={post} />
        ))}
    </ul>
    </div>
);
}

export default PostList;