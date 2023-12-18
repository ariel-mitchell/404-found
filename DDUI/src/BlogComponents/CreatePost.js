import React, { useState, useEffect } from "react";
import axios from "axios";

function CreatePost () {
    const [post, setPost] = useState({ title: '', content: '', author: '',});

    const handleSubmit = async (e) => {
        e.preventDeault();
        try {
            const response = await axios.post('http://localhost:8080/posts/create', post);
            console.log('Post created:', response.data);
        } catch (error) {
            console.error('Error creating post:', error);
        }
    };

    
}