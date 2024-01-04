import React, { useState, useEffect } from 'react';
import axios from 'axios';

const PostComponent = () => {
  // State variables to manage posts and new post creation
  const [posts, setPosts] = useState([]);
  const [newPost, setNewPost] = useState({
    title: '',
    content: '',
  });

  // Fetch all posts from the backend when the component mounts
  useEffect(() => {
    fetchAllPosts();
  }, []);

  // Function to fetch all posts from the backend
  const fetchAllPosts = () => {
    axios.get('http://localhost:8080/posts')
      .then(response => {
        setPosts(response.data);
      })
      .catch(error => {
        console.error('Error fetching posts:', error);
      });
  };

  // Function to handle changes in the new post form
  const handleInputChange = e => {
    setNewPost({
      ...newPost,
      [e.target.name]: e.target.value,
    });
  };

  // Function to submit a new post to the backend
  const handlePostSubmit = async e => {
    e.preventDefault();
    try {
      const response = await axios.post('http://localhost:8080/posts/create', newPost);
      console.log('Post created:', response.data);
      // Fetch updated posts after creating a new one
      fetchAllPosts();
      // Clear the form after submission
      setNewPost({
        title: '',
        content: '',
      });
    } catch (error) {
      console.error('Error creating post:', error);
    }
  };

  return (
    <div>
      <h1>Posts</h1>
      <ul>
        {posts.map(post => (
          <li key={post.id}>
            <h3>{post.title}</h3>
            <p>{post.content}</p>
          </li>
        ))}
      </ul>

      <h2>Create a New Post</h2>
      <form onSubmit={handlePostSubmit}>
        <label>
          Title:
          <input type="text" name="title" value={newPost.title} onChange={handleInputChange} />
        </label>
        <br />
        <label>
          Content:
          <textarea name="content" value={newPost.content} onChange={handleInputChange} />
        </label>
        <br />
        <button type="submit">Create Post</button>
      </form>
    </div>
  );
};

export default PostComponent;