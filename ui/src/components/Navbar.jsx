import Container from 'react-bootstrap/Container';
import Navbar from 'react-bootstrap/Navbar';
import Nav from 'react-bootstrap/Nav';

function NavbarHead() {
return(
<Navbar className="bg-body-tertiary">
          <Container fluid style={{ maxWidth: '1380px', backgroundColor: '' }}>
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
          <Navbar.Toggle aria-controls="basic-navbar-nav" />
          <Nav className="me-auto">
                      <Nav.Link href="/">Home</Nav.Link>
                      <Nav.Link href="login">Login</Nav.Link>
                      <Nav.Link href="user-characters">Your Characters</Nav.Link>
                      <Nav.Link href="/character-creator">Character Creator</Nav.Link>
                      <Nav.Link href="/dice-roller">Dice Roller</Nav.Link>
                      <Nav.Link href="/spellbook">Spellbook</Nav.Link>
                      <Nav.Link href="/blog">Blog</Nav.Link>
                      <Nav.Link href="/contact-us">Contact Us</Nav.Link>
          </Nav>
        </Container>
      </Navbar>
  );
}

export default NavbarHead;

