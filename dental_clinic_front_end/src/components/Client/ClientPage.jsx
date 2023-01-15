import React, {useState, useEffect } from "react";
import NotFound from "../../pages/pageNotFound";
import AuthService from "../Services/AuthService";
import ClientTable from "./ClientTable";
import ClientService from "../Services/ClientService";

function ClientPage() {
  const [clients, setClients] = useState(null);

  useEffect(() => {
    ClientService.getClients().then((response) => {
      console.log(response.data);
      setClients(response.data);
    });
  }, []);

  function deleteUser(id) {
    const newClient = [...clients];
    const index = newClient.indexOf(id);
    newClient.splice(index, 1);
    ClientService.deleteClient(id);
    setClients(newClient);
  }

  if (
    (AuthService.getCurrentUser() !== null &&
      AuthService.getCurrentUser().roles.includes("[ROLE_USER]")) ||
    AuthService.getCurrentUser() === null
  ) {
    return <NotFound />;
  }

  if (!clients) return <h1>No users found.</h1>;

  return (
    <div>
      {AuthService.getCurrentUser() !== null &&
        AuthService.getCurrentUser().roles.includes("[ROLE_ADMIN]") && (
          <>
            <div
              style={{
                display: "flex",
                marginTop: "10px",
                justifyContent: "center",
                alignItems: "top",
                height: "10vh",
              }}
            >
              <h1>Clients</h1>
            </div>
            <ClientTable clients={clients} onDelete={deleteUser}></ClientTable>
          </>
        )}
    </div>
  );
}

export default ClientPage;
