import React, {useState, useEffect} from "react";
import axios from "axios";


const PostList = () => {
    const [posts, setPosts] = useState([]);

    useEffect(() => {
        //Fetch from Springboot backend 
        axios.get('https://localhost:3306/dndcreator?useLegacyDatetimeCode=false&verifyServerCertificate=false&useSSL=false&requireSSL=false&allowPublicKeyRetrieval=true&serverTimezone=America/Chicago/api/Posts')
        .then(response =>setPosts(response.data))
        .catch(error => console.log(error))
    }, []);
    return (
        <div>
            <h2>Blog Posts</h2>
            <ul>
                {posts.map(post => (
                <li key={post.id}>
                <strong>{post.title}</strong>
                <p>{post.content}</p>
                </li>
                ))}
            </ul>
        </div>
    );
};

export default PostList;