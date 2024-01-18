import Container from 'react-bootstrap/Container';
import Navbar from 'react-bootstrap/Navbar';
import Nav from 'react-bootstrap/Nav';

function NavbarHead() {
return(
<Navbar className="bg-body-tertiary">
        <Container>
          <Navbar.Brand>
            <img
              alt=""
              src="/NavIcon.png"
              width="300"
              height="168"
              className="d-inline-block align-top"
            />{' '}
            404-Found presents: D&D Character Creator
          </Navbar.Brand>
          <Nav className="me-auto">
                      <Nav.Link href="/">Home</Nav.Link>
                      <Nav.Link href="/characters">Character Creator </Nav.Link>
                      <Nav.Link href="/dice-roller">Dice Roller </Nav.Link>
                      <Nav.Link href="/spellbook">Spellbook </Nav.Link>
          </Nav>
        </Container>
      </Navbar>
  );
}

export default NavbarHead;
