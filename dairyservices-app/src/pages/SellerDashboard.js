import axios from "axios";
import { toast } from "react-toastify";
import { Link, useLocation, useNavigate } from "react-router-dom";
import { useEffect, useState } from "react";

const SellerDashboard = (props) => {

    const { details } = props;
    const navigate = useNavigate();

    const Logout = () => {
        toast.success('Logout Successfully');
        sessionStorage.removeItem('Seller Email');
        navigate('/sellerLogin');
    }

    return (
        <div>
            <div class="container-md">
                <h1 style={{ marginBottom: 20, float: "left" }}>Hello, {details.firstName}</h1>
                <div className="d-grid gap-2 d-md-flex justify-content-md-end" style={{ marginTop: 20 }}>
                    <button className="btn btn-outline-primary" onClick={Logout} type="button">Logout</button>
                </div>
                <img src="./images/consumerdashboard.png" class="img-fluid" alt="Consumer Home" style={{ width: 1300, height: 300 }} />
            </div>
            <div class="container-md" style={{ marginTop: 20 }}>
                <div class="row">
                    <div class="col-sm-6">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">Update Information</h5>
                                <p class="card-text">Update all your profile information such as Name, Address, Phone Number, etc.</p>
                                <a href="#" class="btn btn-outline-success">Update Profile</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">Change Paswword</h5>
                                <p class="card-text">It is always better for security to frequently change your password</p>
                                <a href="#" class="btn btn-outline-danger">Change Password</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="container-md" style={{ marginTop: 20 }}>
                <div class="row">
                    <div class="col-sm-6">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">Order Details</h5>
                                <p class="card-text">Here you get to see all your sell records </p>
                                <a href="#" class="btn btn-outline-info">Get Details</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">Change Order Status</h5>
                                <p class="card-text">Having any issue with our service ?</p>
                                <a href="#" class="btn btn-outline-success">Get Query Form</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="container-md" style={{ marginTop: 20 }}>
                <div class="row">
                    <div class="col-sm-6">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">Manage Products</h5>
                                <p class="card-text">Add or remove products that you added for sell </p>
                                <a href="#" class="btn btn-outline-primary">Get Product List</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">Raise Query</h5>
                                <p class="card-text">Having any issue with our service ?</p>
                                <a href="#" class="btn btn-outline-warning">Get Query Form</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="container-md" style={{ marginTop: 20 }}>
                <div class="row">
                    <div class="col-sm-12">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">Delete Account</h5>
                                <p class="card-text">Want to quit selling with us ? You can again register whenever you want <br /> </p>
                                <a href="#" class="btn btn-danger">Remove Account</a>
                                <p class="card-text">(all information get deleted)</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>




            <div style={{ margin: 30 }}>

            </div>
        </div >
    )


}


export default SellerDashboard;