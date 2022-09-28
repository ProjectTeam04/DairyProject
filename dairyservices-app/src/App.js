import { BrowserRouter, Routes, Route, Link } from 'react-router-dom';
import './App.css';
import NavBar from './pages/NavBar';
import ConsumerRegistration from './pages/ConsumerRegistration';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import Login from './pages/Login';
import ConsumerHome from './pages/ConsumerHome';
import SellerDashboard from './pages/SellerDashboard';
import SellerHome from './pages/SellerHome';
import SellerLogin from './pages/SellerLogin';
import SellerSelection from './pages/SellerSelection';
import SellerRegistration from './pages/SellerRegistration';
import PurchaseDetails from './pages/PurchaseDetails';
import DeleteConsumerAccount from './pages/DeleteConsumerAccount';


function App() {
  return (
    <div className="App">

      <BrowserRouter>
        <NavBar />
        <Routes>
          <Route path='/consumerLogin' element={<Login />} />
          <Route path='/consumerRegistration' element={<ConsumerRegistration />} />
          <Route path='/consumerHome' element={<ConsumerHome />} />
          <Route path='/sellerSelection' element={<SellerSelection />} />
          <Route path='/sellerRegistration' element={<SellerRegistration />} />
          <Route path='/sellerLogin' element={<SellerLogin />} />
          <Route path='/sellerHome' element={<SellerHome />} />
          <Route path='/purchaseDetails' element={<PurchaseDetails />} />
          <Route path='/deleteConsumerAccount' element={<DeleteConsumerAccount />} />
        </Routes>
        <ToastContainer />
      </BrowserRouter>

    </div>
  );
}

export default App;
