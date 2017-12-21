/**
 * IAndroidService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.mr.ws.client;

public interface IAndroidService extends java.rmi.Remote {
    public java.lang.String finishTaskAndFilesUpload(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String acceptTask(java.lang.String arg0, long arg1, int arg2) throws java.rmi.RemoteException;
    public java.lang.String acceptOrderGenTask(java.lang.String arg0, java.lang.Long arg1, double arg2, double arg3) throws java.rmi.RemoteException;
    public java.lang.String getOrderGenTaskInfo(java.lang.String arg0, java.lang.Long arg1) throws java.rmi.RemoteException;
    public java.lang.String isConfigResource(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String loadTroubleType(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String findAttachFiles(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String listneedConstructOrder4Exmobi(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String listneedConstructOrder(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3) throws java.rmi.RemoteException;
    public java.lang.String activeGetAway(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String exmobiDownLoadAttachment(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String getInspItemDetailInfo(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String listOrderGenTaskNew(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String reportHiddenTrouble(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String delayOrder(java.lang.Long arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3) throws java.rmi.RemoteException;
    public java.lang.String uploadGps(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String commitComplainOrderNew(java.lang.Long arg0, java.lang.Long arg1, java.lang.String arg2, java.lang.String arg3) throws java.rmi.RemoteException;
    public java.lang.String listUnFinishLineTask(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String listTaskById(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String fetchBatchState(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String commitComplainOrder(java.lang.Long arg0, java.lang.Long arg1, java.lang.String arg2, java.lang.String arg3) throws java.rmi.RemoteException;
    public java.lang.String modifyUserInfo(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String downloadAttachFile(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String listneedConstructOrder4ExmobiById(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String finishLinePlan(java.lang.String arg0, long arg1) throws java.rmi.RemoteException;
    public java.lang.String findAppointMentRecordByOrderID(java.lang.Long arg0, java.lang.String arg1) throws java.rmi.RemoteException;
    public java.lang.String generateNewPwd() throws java.rmi.RemoteException;
    public java.lang.String listAcceptAndAcceptedAndFinishedTask(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String listNearbyPatrolPoint(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String finishOrderGenTask(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String listOrderGenTask(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String commitOrder(java.lang.Long arg0, boolean arg1, java.lang.String arg2, java.lang.String arg3, java.lang.String arg4) throws java.rmi.RemoteException;
    public java.lang.String login(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, int arg3) throws java.rmi.RemoteException;
    public java.lang.String listDeviceInfos(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String fileUpload(java.lang.String arg0, java.lang.String arg1, java.lang.Long arg2, byte[] arg3, java.lang.String arg4, java.lang.String arg5) throws java.rmi.RemoteException;
    public java.lang.String getUserInfo(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String terminatedTaskInfo(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String listLinePlan(java.lang.String arg0) throws java.rmi.RemoteException;
    public void activeFtthMac(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, java.lang.String arg4, java.lang.String arg5) throws java.rmi.RemoteException;
    public java.lang.String listHiddenTroubleByPatrolPoint(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String getServerTime(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String listneedConstructOrderById(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String listTaskNoLine(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String getInspItemListDetailInfo(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String listneedConstructComplainOrder(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException;
    public java.lang.String uploadAttachFile(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String listComplainOrderNew(java.lang.String arg0) throws java.rmi.RemoteException;
    public int bind(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2) throws java.rmi.RemoteException;
    public java.lang.String resuouceBack(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2) throws java.rmi.RemoteException;
    public java.lang.String[] queryRoomByName(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2) throws java.rmi.RemoteException;
    public java.lang.String[] listDictionaryValues(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException;
    public java.lang.String[] listTask(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, double arg3, double arg4) throws java.rmi.RemoteException;
    public java.lang.String inspLineTaskByRes(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String userCheckin(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String recordAutoInspLineSwitch(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String listconstructFinishOrder(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException;
    public java.lang.String fileUpload4BusinessOpen(java.lang.String arg0, java.lang.String arg1, java.lang.Long arg2, byte[] arg3, long arg4) throws java.rmi.RemoteException;
    public java.lang.String delUploadFile(java.lang.String arg0, java.lang.String arg1, java.lang.Long arg2, java.lang.Long arg3) throws java.rmi.RemoteException;
    public java.lang.String listTaskByPatrolPoint(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String loadTroubleTypeJson(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String loginNew(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String fileDelUpload(java.lang.String arg0) throws java.rmi.RemoteException;
}
