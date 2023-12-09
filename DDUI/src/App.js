import React, { useState, useEffect } from "react"; 

function App() {
  const [posts, setPosts] = useState([]); // An array to hold blog posts

useEffect(() => {
    // Fetch data from API when component mounts
    fetch("/api/posts") // Send a GET request to the /api/posts
      .then((response) => response.json()) // Parse the response as JSON
      .then((data) => setPosts(data)); // Update the posts state with the received data
}, []);

return (
    <div className="App">
    <h1>DnD Character Creator Blog</h1>
    <ul>
        {posts.map((post) => ( // Looping through the posts array
        <li key={post.id}>
        <h3>{post.title}</h3>
        <p>{post.content}</p>
        </li>
        ))}
    </ul>
    </div>
);
}

export default App;