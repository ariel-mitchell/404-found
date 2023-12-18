import React, { useState, useEffect } from 'react';
import axios from 'axios';

function PostList() {
const [posts, setPosts] = useState([]);

useEffect(() => {
    axios.get('http://localhost:8080/posts')
    .then(response => setPosts(response.data))
    .catch(error => console.error('Error fetching posts:', error));
}, []);

return (
    <div>
        <h2>Posts</h2>
        <ul>
            {posts.map(post => (
            <li key={post.id}>
                {post.title} - {post.author}
            </li>
        ))}
        </ul>
    </div>
    );
}

export default PostList;
