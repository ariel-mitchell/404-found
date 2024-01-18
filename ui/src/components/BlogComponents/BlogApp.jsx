
import React, { useState } from "react";
import { Container, Row, Col, Button } from "react-bootstrap";
import BlogList from "./BlogList";
import BlogForm from "./BlogForm";
import BlogItem from "./BlogItem";

const BlogApp = () => {
// State for managing selected post, new post data, posts array, error message, admin status, and edit mode
const [selectedPost, setSelectedPost] = useState(null);
const [newPostTitle, setNewPostTitle] = useState("");
const [newPostContent, setNewPostContent] = useState("");
const [newPostAuthor, setNewPostAuthor] = useState("");
const [posts, setPosts] = useState([
{ id: 1, title: 'App Usage: Mastering the DnD Character Creator App', author: 'C.C. - Mythologist - lvl 20', content: 'Unlock the full potential of the DnD Character Creator App with expert tips. Learn how to efficiently create and manage your characters for immersive Dungeons and Dragons adventures.' },
{ id: 2, title: 'D&D News: Latest Adventures', author: 'T.W. - Loremaster - lvl 20', content: 'Stay updated with the latest news and adventures unfolding. Get exclusive insights into the world of Dungeons and Dragons.' },
{ id: 3, title: 'Enhancing Role Playing Experience', author: 'J.W. - Spellcaster - lvl 20', content: 'Improve your Dungeons and Dragons role-playing experience with expert tips. Dive into the world of immersive storytelling and character development.' },
{ id: 4, title: 'D&D Tips: Mastering Dungeon Creation', author: 'J.V. - Guildmaster - lvl 15', content: 'Learn the art of creating captivating dungeons in your Dungeons and Dragons campaigns. Tips on mastering dungeon design.' },
]);
const [error, setError] = useState("");
const [isAdmin, setIsAdmin] = useState(true); // Set to true for demo purposes
const [editMode, setEditMode] = useState(false);
const [editedPostId, setEditedPostId] = useState(null);

// Function to add a new blog post
const addNewPost = () => {
// Check for empty title, content, or author
if (newPostTitle.trim() === "" || newPostContent.trim() === "" || newPostAuthor.trim() === "") {
    setError("Title, content, and author cannot be empty");
    return;
} else {
    setError("");
}

// Generate a new post object and update the posts array
const id = posts.length + 1;
const newPost = { id, title: newPostTitle, author: newPostAuthor, content: newPostContent };
setPosts([...posts, newPost]);
setNewPostTitle("");
setNewPostContent("");
setNewPostAuthor("");
};

// Function to edit a blog post
const editPost = () => {
// Check for empty title, content, or author
if (newPostTitle.trim() === "" || newPostContent.trim() === "" || newPostAuthor.trim() === "") {
    setError("Title, content, and author cannot be empty");
    return;
} else {
    setError("");
}

// Update the edited post in the posts array
const updatedPosts = posts.map((post) =>
    post.id === editedPostId ? { ...post, title: newPostTitle, author: newPostAuthor, content: newPostContent } : post
);
setPosts(updatedPosts);

// Reset state
setEditMode(false);
setEditedPostId(null);
setNewPostTitle("");
setNewPostContent("");
setNewPostAuthor("");
};

// Function to delete a blog post
const deletePost = (postId) => {
if (isAdmin) {
    // Filter out the selected post from the posts array
    const updatedPosts = posts.filter((post) => post.id !== postId);
    setPosts(updatedPosts);
} else {
    setError("Only admins can delete posts.");
}
};

// Function to handle post selection for editing
const handleSelect = (post) => {
setSelectedPost(post);
setEditMode(true);
setEditedPostId(post.id);
setNewPostTitle(post.title);
setNewPostContent(post.content);
setNewPostAuthor(post.author || ""); // Handle cases where author is not defined
};

// Render the main structure of the app
return (
<Container style={{ paddingTop: "40px", paddingLeft: "20px", paddingRight: "20px" }}>
    <Row>
    <Col>
        {/* Header */}
        <div
        style={{
            backgroundColor: "#3498db",
            padding: "10px",
            borderRadius: "10px",
            marginBottom: "20px",
        }}
        >
        <h1 style={{ fontSize: "24px", fontWeight: "bold", textAlign: "center", color: "white" }}>Blog App</h1>
        </div>
        {/* Conditional rendering based on whether a post is selected */}
        {editMode ? (
        // Display form for editing a blog post
        <BlogForm
            error={error}
            onSubmit={editPost}
            onChangeTitle={setNewPostTitle}
            onChangeContent={setNewPostContent}
            onChangeAuthor={setNewPostAuthor}
            newPostTitle={newPostTitle}
            newPostContent={newPostContent}
            newPostAuthor={newPostAuthor}
        />
        ) : selectedPost === null ? (
        // Display list of blog posts
        <BlogList posts={posts} onDelete={deletePost} onSelect={handleSelect} onEdit={handleSelect} isAdmin={isAdmin} />
        ) : (
        // Display selected blog post details
        <BlogItem
            item={selectedPost}
            onDelete={deletePost}
            onSelect={() => setSelectedPost(null)}
            onEdit={handleSelect}
            isAdmin={isAdmin}
        />
        )}
        {/* Display form for adding a new blog post */}
        {selectedPost === null && !editMode && (
        <BlogForm
            error={error}
            onSubmit={addNewPost}
            onChangeTitle={setNewPostTitle}
            onChangeContent={setNewPostContent}
            onChangeAuthor={setNewPostAuthor}
            newPostTitle={newPostTitle}
            newPostContent={newPostContent}
            newPostAuthor={newPostAuthor}
        />
        )}
    </Col>
    </Row>
</Container>
);
};

export default BlogApp;
