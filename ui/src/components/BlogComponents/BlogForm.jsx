import React from "react";
import { Form, Button } from "react-bootstrap";

const BlogForm = ({
error,
onSubmit,
onChangeTitle,
onChangeContent,
onChangeAuthor,
newPostTitle,
newPostContent,
newPostAuthor,
}) => {
return (
<Form>
    <Form.Group controlId="formTitle">
    <Form.Label>Title</Form.Label>
    <Form.Control
        type="text"
        placeholder="Enter title"
        value={newPostTitle}
        onChange={(e) => onChangeTitle(e.target.value)}
    />
    </Form.Group>

    <Form.Group controlId="formAuthor">
    <Form.Label>Author</Form.Label>
    <Form.Control
        type="text"
        placeholder="Enter author"
        value={newPostAuthor}
        onChange={(e) => onChangeAuthor(e.target.value)}
    />
    </Form.Group>

    <Form.Group controlId="formContent">
    <Form.Label>Content</Form.Label>
    <Form.Control
        as="textarea"
        rows={3}
        placeholder="Enter content"
        value={newPostContent}
        onChange={(e) => onChangeContent(e.target.value)}
    />
    </Form.Group>

    {error && <p style={{ color: "red" }}>{error}</p>}

    <Button variant="primary" onClick={onSubmit}>
    Submit
    </Button>
</Form>
);
};

export default BlogForm;