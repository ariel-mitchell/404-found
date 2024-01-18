// Post component displaying individual blog posts using Bootstrap React Card

const Post = ({ content }) => {
      return (
          <div className="col-md-4 mb-4">
              <Card>
                  <Card.Body>
                      <Card.Subtitle className="mb-2 text-muted">{content.department}</Card.Subtitle>
                      <Card.Title className="mb-3">{content.title}</Card.Title>
                      <Card.Text>{content.info}</Card.Text>
                  </Card.Body>
                  <Card.Footer className="text-muted">
                      <span className="me-2">{content.author}</span>
                      <span>{content.designation}</span>
                  </Card.Footer>
              </Card>
          </div>
      );
      };
      
      export default Post;