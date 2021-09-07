import DataTable from "components/data-table";
import Footer from "components/footer";
import NavBar from "components/navbar";

function App() {
  return (
    <>
      <NavBar />
      <div className="container">
        <h1 className="text-primary">Semana Dev Superior 4</h1>
        <DataTable/>
      </div>
      <Footer />
    </>
  );
}

export default App;
