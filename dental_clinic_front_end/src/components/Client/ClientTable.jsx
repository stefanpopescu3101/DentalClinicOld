import * as React from "react";
import { DataGrid } from "@mui/x-data-grid";
import { useEffect, useState } from "react";
import NotFound from "../../pages/pageNotFound";
import ClientService from "../Services/ClientService";

const columns = [
  { field: "firstName", headerName: "First name", flex: 1 },
  { field: "lastName", headerName: "Last name", flex: 1 },
  { field: "email", headerName: "Email address", flex: 1 },
  { field: "phone", headerName: "Email address", flex: 1 },
];

export default function ClientTable() {
      const [clients, setClients] = useState([]);

  useEffect(() => {
      ClientService.getClients().then((response) => {
      setClients(response.data);
      console.log(response.data);
    });
  }, []);

  // eslint-disable-next-line
    clients.map((user) => {
    // eslint-disable-next-line
    clients["id"] = clients.id;
  });

  if (!clients) return <NotFound />;

  return (
    <div style={{ height: 700, width: "flex" }}>
      <DataGrid
        density="comfortable"
        rows={clients}
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
