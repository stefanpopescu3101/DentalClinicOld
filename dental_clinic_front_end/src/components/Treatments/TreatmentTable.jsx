import * as React from "react";
import { DataGrid } from "@mui/x-data-grid";
import { useEffect, useState } from "react";
import { IconButton } from "@mui/material";
import {Delete} from "@mui/icons-material";
import { Modal } from "react-bootstrap";
import AddIcon from "@mui/icons-material/Add";
import TreatmentService from "../Services/TreatmentService";
import TreatmentForm from "./TreatmentForm";

export default function TreatmentTable() {
  const [showPost, setShowPost] = useState(false);
  const handleClosePost = () => setShowPost(false);
  const handleShowPostForm = () => setShowPost(true);

  const [treatments, setTreatments] = useState([]);

  useEffect(() => {
    TreatmentService.getTreatments().then((response) => {
      setTreatments(response.data);
    });
  }, []);

  // eslint-disable-next-line
  treatments.map((treatment) => {
    // eslint-disable-next-line
    treatment["id"] = treatment.id;
  });

  const columns = [
    { field: "title", headerName: "Title", flex: 1 },
    { field: "description", headerName: "Description", flex: 1 },
    { field: "duration", headerName: "Duration", flex: 1 },
    { field: "price", headerName: "Price", flex: 1 },
    { field: "doctorID", headerName: "Doctor", flex: 1 },

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
    TreatmentService.deleteTreatment(id)
      .then((response) => {
        if (response.data !== null) {
          alert("Treatment deleted successfully.");
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
            <Modal.Title>Treatment information</Modal.Title>
          </Modal.Header>
          <Modal.Body>
            <TreatmentForm />
          </Modal.Body>
        </Modal>
      </>
      <br />
      <br />
      <DataGrid
        density="comfortable"
        rows={treatments}
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
