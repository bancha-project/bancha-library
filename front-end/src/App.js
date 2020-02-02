// in src/App.js
import React from 'react';
import {Admin, Resource} from 'react-admin';
import jsonServerProvider from 'ra-data-json-server';
import BookIcon from '@material-ui/icons/ImportContacts';
import Dashboard from './Dashboard';
import authProvider from './sample/authProvider';
import {BookCreate, BookEdit, BookList} from "./app/book";

const dataProvider = jsonServerProvider(process.env.REACT_APP_API_URL);
const App = () => (
    <Admin dashboard={Dashboard} authProvider={authProvider} dataProvider={dataProvider}>
        <Resource name="books" list={BookList} icon={BookIcon} create={BookCreate} edit={BookEdit}/>
    </Admin>
);
export default App;

