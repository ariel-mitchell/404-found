import React, { useState, useEffect } from "react";
import axios from "axios";

function PostLlist() {
    const [posts, setPosts] = useState([]);

    useEffect(() => {
        axios.get('http://localhost:8080/posts')
        .then(response => setPosts(response.data))
        .catch(console.error('Error retrieving posts:', error));
    }, []);

    return (
        <div>
            <h2>404-Found</h2>
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

export default PostLlist;