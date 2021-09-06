import React from 'react';
import NavBar from 'components/NavBar';
import Footer from 'components/Footer';

function App() {
   return (
      <>
         <NavBar />
         <div className="container">
            <h1 className="text-primary">Olá</h1>
         </div>
         <Footer/>
      </>
   );
}

export default App;
