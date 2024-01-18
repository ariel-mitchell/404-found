import Container from 'react-bootstrap/Container';
import Navbar from 'react-bootstrap/Navbar';
import Nav from 'react-bootstrap/Nav';

function NavbarHead() {
return(
<Navbar className="bg-body-tertiary">
          <Container fluid style={{backgroundColor: 'gray' }}>
          <Navbar.Brand>
            <img
              alt=""
              src="/NavIcon.png"
              width="300"
              height="168"
              className="d-inline-block align-top"
            />{' '}
            <strong>404-Found: D&D Character Creator</strong>
          </Navbar.Brand>
          <Container fluid style={{backgroundColor: 'red', textAlign: 'center' }}>
          <Nav fluid style={{display: 'inline-flex', width: 800, height: 40}} className="me-auto">
                      <Nav.Link style={{color: 'yellow', display: "inline-block", textAlign: 'center'}} href="/">Home</Nav.Link>
                      <Nav.Link style={{color: 'yellow', display: "inline-block"}} href="login">Login</Nav.Link>
                      <Nav.Link style={{color: 'yellow', display: "inline-block"}} href="user-characters">Your Characters</Nav.Link>
                      <Nav.Link style={{color: 'yellow', display: "inline-block"}} href="/character-creator">Character Creator</Nav.Link>
                      <Nav.Link style={{color: 'yellow', display: "inline-block"}} href="/dice-roller">Dice Roller</Nav.Link>
                      <Nav.Link style={{color: 'yellow', display: "inline-block"}} href="/spellbook">Spellbook</Nav.Link>
                      <Nav.Link style={{color: 'yellow', display: "inline-block"}} href="/blog">Blog</Nav.Link>
                      <Nav.Link style={{color: 'yellow', display: "inline-block"}} href="/contact-us">Contact Us</Nav.Link>
          </Nav>
          </Container>
        </Container>
      </Navbar>

  );
}

export default NavbarHead;

