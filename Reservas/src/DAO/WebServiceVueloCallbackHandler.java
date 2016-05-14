
/**
 * WebServiceVueloCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4.1  Built on : Aug 19, 2008 (10:13:39 LKT)
 */

    package DAO;

    /**
     *  WebServiceVueloCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class WebServiceVueloCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public WebServiceVueloCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public WebServiceVueloCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for getInstancia method
            * override this method for handling normal response from getInstancia operation
            */
           public void receiveResultgetInstancia(
                    DAO.WebServiceVueloStub.GetInstanciaResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getInstancia operation
           */
            public void receiveErrorgetInstancia(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getNroAsientosDisponibles method
            * override this method for handling normal response from getNroAsientosDisponibles operation
            */
           public void receiveResultgetNroAsientosDisponibles(
                    DAO.WebServiceVueloStub.GetNroAsientosDisponiblesResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getNroAsientosDisponibles operation
           */
            public void receiveErrorgetNroAsientosDisponibles(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getNroVuelo method
            * override this method for handling normal response from getNroVuelo operation
            */
           public void receiveResultgetNroVuelo(
                    DAO.WebServiceVueloStub.GetNroVueloResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getNroVuelo operation
           */
            public void receiveErrorgetNroVuelo(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for cancelarReservacion method
            * override this method for handling normal response from cancelarReservacion operation
            */
           public void receiveResultcancelarReservacion(
                    DAO.WebServiceVueloStub.CancelarReservacionResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from cancelarReservacion operation
           */
            public void receiveErrorcancelarReservacion(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for reservarAsiento method
            * override this method for handling normal response from reservarAsiento operation
            */
           public void receiveResultreservarAsiento(
                    DAO.WebServiceVueloStub.ReservarAsientoResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from reservarAsiento operation
           */
            public void receiveErrorreservarAsiento(java.lang.Exception e) {
            }
                


    }
    