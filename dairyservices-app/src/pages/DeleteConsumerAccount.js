import { useEffect } from "react";
import { useLocation } from 'react-router-dom';

const DeleteConsumerAccount = () => {

    const location = useLocation();

    useEffect(() => {
        const { emailId } = location.state;
        console.log(emailId);
    }, []);



    return (
        <div>

        </div>
    )
}


export default DeleteConsumerAccount;