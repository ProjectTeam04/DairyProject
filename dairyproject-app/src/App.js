import { BrowserRouter, Routes, Route, Link } from 'react-router-dom';
import './App.css';
import NavBar from './pages/NavBar';
import ConsumerRegistration from './pages/ConsumerRegistration';
import { ToastContainer, toast, Slide } from 'react-toastify';
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
import OrderDetails from './pages/OrderDetails';
import DeleteSellerAccount from './pages/DeleteSellerAccount';
import SellerManageProducts from './pages/SellerManageProducts';
import ChangeDeliveryStatus from './pages/ChangeDeliveryStatus';
import PurchaseProduct from './pages/PurchaseProduct';
import ConsumerSellerSelection from './pages/ConsumerSellerSelection';
import AdminLogin from './pages/AdminLogin';
import AdminHome from './pages/AdminHome';
import ManageProductsAdmin from './pages/ManageProductsAdmin';
import AllConsumerAdmin from './pages/AllConsumerAdmin';
import AllSellerAdmin from './pages/AllSellerAdmin';
import SellerProductsDetailsForAdmin from './pages/SellerProductDetailsForAdmin';
import AllPurchaseDetailsForAdmin from './pages/AllPurchaseDetailsForAdmin';
import DeletedConsumerRecord from './pages/DeletedConsumerRecord';
import DeletedSellerRecord from './pages/DeletedSellerRecord';




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
          <Route path='/orderDetails' element={<OrderDetails />} />
          <Route path='/deleteSellerAccount' element={<DeleteSellerAccount />} />
          <Route path='/sellerManageProducts' element={<SellerManageProducts />} />
          <Route path='/changeDeliveryStatus' element={<ChangeDeliveryStatus />} />
          <Route path='/purchaseProduct' element={<PurchaseProduct />} />
          <Route path='/consumerSellerSelection' element={<ConsumerSellerSelection />} />
          <Route path='/adminLogin' element={<AdminLogin />} />
          <Route path='/adminHome' element={<AdminHome />} />
          <Route path='/manageProductsAdmin' element={<ManageProductsAdmin />} />
          <Route path='/allConsumerAdmin' element={<AllConsumerAdmin />} />
          <Route path='/allSellerAdmin' element={<AllSellerAdmin />} />
          <Route path='/sellerProductsDetailsForAdmin' element={<SellerProductsDetailsForAdmin />} />
          <Route path='/allPurchaseDetailsForAdmin' element={<AllPurchaseDetailsForAdmin />} />
          <Route path='/deletedConsumerRecord' element={<DeletedConsumerRecord />} />
          <Route path='/deletedSellerRecord' element={<DeletedSellerRecord />} />
        </Routes>

        <ToastContainer
          position="top-center"
          autoClose={3000}
          hideProgressBar={true}
          newestOnTop={false}
          transition={Slide}
          closeOnClick
          rtl={false}
          pauseOnFocusLoss
          draggable
          pauseOnHover
        />
      </BrowserRouter>

    </div>
  );
}


export default App;
