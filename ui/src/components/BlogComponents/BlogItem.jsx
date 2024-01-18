// BlogItem.jsx
import React from 'react';
import { Button, ListGroup, Card } from 'react-bootstrap';

// BlogItem component to represent an individual blog post
const BlogItem = ({ item, onDelete, onSelect, onEdit, isAdmin }) => (
<ListGroup.Item onClick={() => onSelect(item)}>
<Card style={{ cursor: 'pointer', marginBottom: '10px', borderRadius: '10px' }}>
    <Card.Body>
    {/* Display blog post title */}
    <Card.Title style={{ fontSize: '18px', fontWeight: 'bold', marginBottom: '10px', textDecoration: 'underline' }}>
        {item.title}
    </Card.Title>
    {/* Display blog post author */}
    <Card.Subtitle style={{ fontSize: '14px', color: 'gray', marginBottom: '10px' }}>Author: {item.author}</Card.Subtitle>
    {/* Display blog post content */}
    <Card.Text style={{ fontSize: '16px' }}>{item.content}</Card.Text>
    {/* Buttons for editing and deleting the blog post (conditional based on admin status) */}
    {isAdmin && (
        <>
        <Button
            variant="primary"
            style={{ marginRight: '10px' }}
            onClick={(e) => {
            e.stopPropagation(); // Prevents the onClick of the parent ListGroup.Item from triggering
            onEdit(item);
            }}
        >
            Edit
        </Button>
        <Button
            variant="danger"
            onClick={(e) => {
            e.stopPropagation(); // Prevents the onClick of the parent ListGroup.Item from triggering
            onDelete(item.id);
            }}
        >
            Delete
        </Button>
        </>
    )}
    </Card.Body>
</Card>
</ListGroup.Item>
);

export default BlogItem;
