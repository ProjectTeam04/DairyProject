import axios from "axios";
import { toast } from "react-toastify";
import { Link, Navigate, useLocation, useNavigate } from "react-router-dom";
import { useEffect, useState } from "react";

const AdminHome = () => {

    const navigate = useNavigate();

    const Logout = () => {
        toast.success('Admin Logout Successfull');
        sessionStorage.removeItem('Admin Email');
        navigate('/adminLogin');
    }

    return (
        <div>
            <div className="container-md">
                <h1 style={{ marginLeft: 445, marginBottom: 20, float: "left" }}>Welcome Administrator</h1>
                <div className="d-grid gap-2 d-md-flex justify-content-md-end" style={{ marginTop: 20 }}>
                    <button className="btn btn-outline-primary" onClick={Logout} type="button">Logout</button>
                </div><br />
            </div >
            <div className="container-md" style={{ marginTop: 20 }}>
                <div className="row">
                    <div className="col-sm-4">
                        <div className="card">
                            <div className="card-body">
                                <h5 className="card-title">Manage Products</h5>
                                <p className="card-text">Add / remove products to make available for sell </p>
                                <Link className="btn btn-outline-success" to="/manageProductsAdmin">Manage Products</Link>
                            </div>
                        </div>
                    </div>
                    <div className="col-sm-4">
                        <div className="card">
                            <div className="card-body">
                                <h5 className="card-title">Get Consumers Detail</h5>
                                <p className="card-text">Manage all registered consumers</p>
                                <Link className="btn btn-outline-primary" to="/allConsumerAdmin">Consumers Detail</Link>
                            </div>
                        </div>
                    </div>
                    <div className="col-sm-4">
                        <div className="card">
                            <div className="card-body">
                                <h5 className="card-title">Get Sellers Detail</h5>
                                <p className="card-text">Manage all registered sellers</p>
                                <Link className="btn btn-outline-warning" to="/allSellerAdmin">Sellers Detail</Link>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div className="container-md" style={{ marginTop: 20 }}>
                <div className="row">
                    <div className="col-sm-4">
                        <div className="card">
                            <div className="card-body">
                                <h5 className="card-title">Purchase Details</h5>
                                <p className="card-text">Get all Purchase Records </p>
                                <Link className="btn btn-outline-dark" to="/allPurchaseDetailsForAdmin">Show Record</Link>
                            </div>
                        </div>
                    </div>
                    <div className="col-sm-4">
                        <div className="card">
                            <div className="card-body">
                                <h5 className="card-title">Deleted Consumers Record</h5>
                                <p className="card-text">Get all deleted consumer history</p>
                                <Link className="btn btn-outline-danger" to="/deletedConsumerRecord">Get Record</Link>
                            </div>
                        </div>
                    </div>
                    <div className="col-sm-4">
                        <div className="card">
                            <div className="card-body">
                                <h5 className="card-title">Deleted Sellers Record</h5>
                                <p className="card-text">Get all deleted seller history <br /> </p>
                                <Link className="btn btn-outline-primary" to="/deletedSellerRecord">Get Record</Link>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div className="container-md" style={{ marginTop: 20 }}>
                <div className="row">
                    <div className="col-sm-4">
                        <div className="card">
                            <div className="card-body">
                                <h5 className="card-title">Consumer Queries</h5>
                                <p className="card-text">Get all Queries submited by Consumers </p>
                                <button className="btn btn-outline-warning">Get Queries</button>
                            </div>
                        </div>
                    </div>
                    <div className="col-sm-4">
                        <div className="card">
                            <div className="card-body">
                                <h5 className="card-title">Seller Queries</h5>
                                <p className="card-text">Get all Queries submited by Sellers</p>
                                <a className="btn btn-outline-primary">Get Queries</a>
                            </div>
                        </div>
                    </div>
                    <div className="col-sm-4">
                        <div className="card">
                            <div className="card-body">
                                <h5 className="card-title">Feedback</h5>
                                <p className="card-text">Get all publicaly submitted feedback <br /> </p>
                                <a className="btn btn-outline-success">Get Feedback</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div >
    )


}

export default AdminHome;