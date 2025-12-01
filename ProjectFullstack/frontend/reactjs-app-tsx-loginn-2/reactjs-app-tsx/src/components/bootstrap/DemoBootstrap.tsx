import React, { useState } from 'react';
import { Modal, ModalBody, ModalHeader, Button } from 'reactstrap';
import styles from './DemoBootstrap.module.css';

function DemoBootstrap() {
  const [open, setOpen] = useState(false);

  return (
    <div style={{ margin: '24px 0' }}>
        {/* Demo Bootstrap Button */}
        <Button color="danger">Danger!</Button>

        {/* Demo Bootstrap Modal + css Module */}
      <Button color="primary" cssModule={{ btn: styles.hyperspeedBtn }} 
        onClick={() => setOpen(true)}>
        Open Modal
      </Button>
      <Modal isOpen={open} toggle={() => setOpen(false)}>
        <ModalHeader toggle={() => setOpen(false)}>
          Modal title
        </ModalHeader>
        <ModalBody>
          Modal body text goes here.
        </ModalBody>
      </Modal>
    </div>
  );
}

export default DemoBootstrap;
