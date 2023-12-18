import React, { useState } from 'react';
import axios from 'axios';

// post object as a prop
function Post({ post }) {
    // Initialize state variables for likes, comments, and the new comment input
    const [likes, setLikes] = useState(post.likes);
    const [comments, setComments] = useState(post.comments);
    const [newComment, setNewComment] = useState('');

    // handle liking a post
    const handleLike = async () => {
        setLikes(likes + 1);
        // TODO: Make request to backend to update the post likes
    };

    // handle changes to the new comment input
    const handleCommentChange = (event) => {
        setNewComment(event.target.value);
    };

    // submitting a new comment
    const handleCommentSubmit = async (event) => {
        event.preventDefault();

        try {
            // Make a POST request to the backend to create a new comment
            const response = await axios.post(`http://localhost:8080/api/posts/${post.id}/comments`, { text: newComment });
            // Update the comments state with the new comment
            setComments([...comments, response.data]);
            // Clear the new comment input
            setNewComment('');
        } catch (error) {
            console.error('Error submitting comment:', error);
        }
    };

    // Render the post with its title, content, likes, comments, and a form to submit a new comment
    return (
        <div>
            <h2>{post.title}</h2>
            <p>{post.content}</p>
            <button onClick={handleLike}>Like</button>
            <p>Likes: {likes}</p>
            <ul>
                {comments.map((comment, index) => (
                    <li key={index}>{comment.text}</li>
                ))}
            </ul>
            <form onSubmit={handleCommentSubmit}>
                <input type="text" value={newComment} onChange={handleCommentChange} />
                <button type="submit">Submit Comment</button>
            </form>
        </div>
    );
}

export default Post;