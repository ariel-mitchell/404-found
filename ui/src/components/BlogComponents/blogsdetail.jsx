import React from 'react';

export default function BlogDetails({ location }) {
// Retrieve the blog post based on the id from the URL params
const postId = location.pathname.split('/').pop();

// Access postData from location state with default value
const postData = (location.state && location.state.postData) || [];

// Find the selected blog post based on postId
const selectedPost = postData.find(post => post.id === parseInt(postId));

return (
<div>
    {selectedPost ? (
    // Display blog post details if the post is found
    <div>
        <h2>{selectedPost.title}</h2>
        <p>{selectedPost.description}</p>
    </div>
    ) : (
    // Display a message for an invalid or not found post
    <p>Blog post not found</p>
    )}
</div>
);
}
