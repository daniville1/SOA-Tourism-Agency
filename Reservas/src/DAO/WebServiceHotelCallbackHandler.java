
/**
 * WebServiceHotelCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4.1  Built on : Aug 19, 2008 (10:13:39 LKT)
 */

    package DAO;

    /**
     *  WebServiceHotelCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class WebServiceHotelCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public WebServiceHotelCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public WebServiceHotelCallbackHandler(){
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
                    DAO.WebServiceHotelStub.GetInstanciaResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getInstancia operation
           */
            public void receiveErrorgetInstancia(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for reservarHabitacion method
            * override this method for handling normal response from reservarHabitacion operation
            */
           public void receiveResultreservarHabitacion(
                    DAO.WebServiceHotelStub.ReservarHabitacionResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from reservarHabitacion operation
           */
            public void receiveErrorreservarHabitacion(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getCtdHabDisponibles method
            * override this method for handling normal response from getCtdHabDisponibles operation
            */
           public void receiveResultgetCtdHabDisponibles(
                    DAO.WebServiceHotelStub.GetCtdHabDisponiblesResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getCtdHabDisponibles operation
           */
            public void receiveErrorgetCtdHabDisponibles(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for cancelarReservacion method
            * override this method for handling normal response from cancelarReservacion operation
            */
           public void receiveResultcancelarReservacion(
                    DAO.WebServiceHotelStub.CancelarReservacionResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from cancelarReservacion operation
           */
            public void receiveErrorcancelarReservacion(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getHotelesConHabDisponibles method
            * override this method for handling normal response from getHotelesConHabDisponibles operation
            */
           public void receiveResultgetHotelesConHabDisponibles(
                    DAO.WebServiceHotelStub.GetHotelesConHabDisponiblesResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getHotelesConHabDisponibles operation
           */
            public void receiveErrorgetHotelesConHabDisponibles(java.lang.Exception e) {
            }
                


    }
    