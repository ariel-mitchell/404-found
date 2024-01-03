import React, { useState } from "react";
import axios from "axios";

function CreatePost() {
    const [title, setTitle] = useState("");
    const [content, setContent] = useState("");

    const handleTitleChange = (event) => {
        setTitle(event.target.value);
    };

    const handleContentChange = (event) => {
        setContent(event.target.value);
    };

    const handleSubmit = async (event) => {
        event.preventDefault();

        try {
            await axios.post("http://localhost:8080/api/posts", { 
                title, 
                content,
        });
    } catch (error) {
        console.error("Error creating post:", error);
    }
};

return (
    <form onSubmit={handleSubmit} className="create-post-form">
        <h2>Create Post</h2>
        <label htmlFor="create-title">Title:</label>
        <input
            id="create-title"
            type="text"
            value={title}
            onChange={handleTitleChange}
        />
        <label htmlFor="create-content">Content:</label>
        <textarea
            id="create-content"
            value={content}
            onChange={handleContentChange}
        />
        <input type="submit" value="Create" />
    </form>
    );
}

export default CreatePost;
