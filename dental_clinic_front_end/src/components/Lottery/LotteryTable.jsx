import * as React from "react";
import { DataGrid } from "@mui/x-data-grid";
import { useEffect, useState } from "react";
import { IconButton } from "@mui/material";
import {Delete} from "@mui/icons-material";
import { Modal } from "react-bootstrap";
import AddIcon from "@mui/icons-material/Add";
import LotteryService from "../Services/LotteryService";
import LotteryForm from "./LotteryForm";

export default function LotteryTable() {
  const [showPost, setShowPost] = useState(false);
  const handleClosePost = () => setShowPost(false);
  const handleShowPostForm = () => setShowPost(true);

  const [lotteries, setLotteries] = useState([]);

  useEffect(() => {
    LotteryService.getLotteries().then((response) => {
      setLotteries(response.data);
    });
  }, []);

  // eslint-disable-next-line
  lotteries.map((post) => {
    // eslint-disable-next-line
     post["id"] = post.id;
  });

  const columns = [
    { field: "name", headerName: "Name", flex: 1 },
    { field: "description", headerName: "Description", flex: 1 },
    { field: "capacity", headerName: "Capacity", flex: 1 },
    { field: "nrOfClients", headerName: "Clients", flex: 1 },

    {
      field: "Actions",
      flex: 1,
      renderCell: (cellValues) => {
        return (
          <div>
            <IconButton
              aria-label="delete"
              onClick={() => {
                handleClick(1, cellValues);
              }}
            >
              <Delete />
            </IconButton>
          </div>
        );
      },
    },
  ];

  const handleDelete = (id) => {
    LotteryService.deleteLottery(id)
      .then((response) => {
        if (response.data !== null) {
          alert("Lottery deleted successfully.");
          window.location.reload();
        }
      });
  };

  function handleClick(mode, selected) {
    switch (mode) {
      case 0:
        // window.history.pushState(selected.row.id);
        break;
      case 1:
        handleDelete(selected.row.id);
        break;
      default:
        window.history.pushState(selected.row.id);
        break;
    }
  }

  return (
    <div style={{ height: 700, width: "flex" }}>
      <>
        <AddIcon variant="primary" onClick={handleShowPostForm}></AddIcon>
        <Modal
          show={showPost}
          onHide={handleClosePost}
          aria-labelledby="example-modal-sizes-title-lg"
          size="lg"
        >
          <Modal.Header closeButton>
            <Modal.Title>Lottery information</Modal.Title>
          </Modal.Header>
          <Modal.Body>
            <LotteryForm />
          </Modal.Body>
        </Modal>
      </>
      <br />
      <br />
      <DataGrid
        density="comfortable"
        rows={lotteries}
        columns={columns}
        pageSize={5}
        rowsPerPageOptions={[5]}
        disableColumnSelector
        disableMultipleSelection={true}
        disableSelectionOnClick={true}
      />
    </div>
  );
}
