/*---------------------------------------------------------------------------------------
 * Object Name: TDMConstants.Java
 * 
 * --------------------------------------------------------------------------------------
 *
 * Copyright: 2015 Capgemini Financial Services
 *---------------------------------------------------------------------------------------*/

package com.tdm.constant;

/**
 * Class which will provides the String final constants i.e JSP names, request
 * handler mappings, request parameters , strings and error codes.
 */

public final class TDMConstants
{
	public static final String SCOPE_SESSION = "session";

	public static final int BUFFER_SIZE = 4096;

	public static final String UNCHECKED = "unchecked";

	// Request Mappings
	public static final String MAP_POPEMAIL = "/popupEmail";
	public static final String MAP_L1L2SENDMAIL = "/l1l2SendEmail";
	public static final String MAP_POPUPEMAIL_USER = "/popupEmailUser";
	public static final String MAP_LOGIN = "/login";
	public static final String MAP_TESDA_LOGIN = "/tesdaLogin";
	public static final String MAP_TESDA_ADMIN = "/testdaAdmin";
	public static final String MAP_INDEX = "/index";
	public static final String MAP_INDEXCOMMANDOR = "/indexCmdCtr";
	public static final String MAP_TDM_TRAINING = "/training";
	public static final String MAP_403PAGE = "/403page";
	public static final String MAP_SESSIONEXP = "/sessionExp";
	public static final String MAP_AUTHFAIL = "/authFail";
	public static final String MAP_BACK = "/back";
	public static final String MAP_LOGOUT = "/logout";
	public static final String MAP_FORGOT_PASSWORD = "fPassword";
	public static final String MAP_LOGINFORGOT_PASSWORD = "/loginforgotPassword";
	public static final String MAP_DOWNLOAD_USERMANUAL = "/downloadUserManual";
	public static final String MAP_TDM_DTMASKDASHBORAD = "/tdmDtMaskDashboard";
	public static final String MAP_TDM_DTMASK_DASHBOARD = "/tdmDtMaskDashBoardCR";
	public static final String MAP_TDM_DATAMASKING = "/tdmDataMasking";
	public static final String MAP_TDM_DATAMASKING_PG2 = "/tdmDataMaskingPage2";
	public static final String MAP_TDM_DATAMASKING_PG3 = "/tdmDataMaskingPage3";
	public static final String MAP_GETDATA_MASKREQDTLS = "/getDataMaskRequestDtls";
	public static final String MAP_GETDATA_MASKREQDTLS_PG2 = "/getDataMaskRequestDtlsForPage2";
	public static final String MAP_GETDATA_MASKREQDTLS_PG3 = "/getDataMaskRequestDtlsForPage3";
	public static final String MAP_TDMMASKING_FR = "/tdmMaskingFR";
	public static final String MAP_TDMMASKING_CR = "/tdmMaskingCR";
	public static final String MAP_TESDA_USERCREATE = "/tesdaUserCreate";
	public static final String MAP_TESTDISPLAY_ADMIN = "/testdisplayAdmin";
	public static final String MAP_TEST_DA_ADMIN = "/testdaAdmin";
	public static final String MAP_EDITUSER = "/editUser";
	public static final String MAP_TESDA_CREATEUSER = "/tesdaCreateNewUser";
	public static final String MAP_VALIDATE_USERID = "/validateUserId";
	public static final String MAP_DELETEUSER = "/deleteUser";
	public static final String MAP_TDM_CHANGEREQEXT = "/tdmChangeReqExt";
	public static final String MAP_TDM_CHANGEREQ_ID = "/tdmChangeReqId";
	public static final String MAP_TESTDA_CLAIMUSER = "/testdaClaimUser";
	public static final String MAP_TESTDA_CLAIMUSER_BACK = "/testdaClaimUserBack";
	public static final String MAP_TDM_COMMANDCENTER_METRICS = "/tdmCmdCenterMetrics";
	public static final String MAP_TDM_COMMANDCENTER_METRICSDOWNLOAD = "/tdmCmdCenterMetricsDownload";
	public static final String MAP_TDMDATA_SUBSETTING = "/tdmDataSubsetting";
	public static final String MAP_TDM_CHNAGEMGMT = "/tdmChangeMgmt";
	public static final String MAP_TDM_DATAREFRESH = "/tdmDataRefresh";
	public static final String MAP_TDM_TESTDATA_REQ = "/tdmTestDataRequest";
	public static final String MAP_TDM_ESTIMATIONTOOL = "/tdmEstimationTool";
	public static final String MAP_TDP_ESTIMATIONTOOL = "/tdpEstimationTool";
	public static final String MAP_TDP_SENSITIVE_PROFILER = "/tdpSensitiveProfiler";
	public static final String MAP_DOWNLOAD_TDPEST_TOOL = "/downloadTdpEstTool";
	public static final String MAP_DOWNLOAD_TDMEST_TOOL = "/downloadTdmEstTool";
	public static final String MAP_INDEX_GOVN = "/indexGovn";
	public static final String MAP_BLUEBOOKPAGE = "/blueBookPage";
	public static final String MAP_DOWNLOAD_BLUEBOOK = "/downloadBlueBook";
	public static final String MAP_MYRESERVATION_PROV = "/myReservationProv";
	public static final String MAP_UNRESERVE_PROV = "/unreserveProv";
	public static final String MAP_MYRESERVATION_SUBC = "/myReservationSubc";
	public static final String MAP_UNRESERVE_SUBC = "/unreserveSubc";
	public static final String MAP_MYRESERVATION_CLAIM = "/myReservationClaim";
	public static final String MAP_UNRESERVE_CLAIM = "/unreserveClaim";
	public static final String MAP_RESERVATIONNS = "/reservationNS";
	public static final String MAP_TDMNS_SEARCH = "/tdmNSSearch";
	public static final String MAP_TESDA_NONSTAND = "/testdaNonStand";
	public static final String MAP_TDM_ONBOARD_REQ = "/tdmOnboardReq";
	public static final String MAP_TDMONBOARDING_DASHBOARD = "/tdmOnBoardingDashBoard";
	public static final String MAP_TDMONBOARDING_DASHBOARDCR = "/tdmOnBoardingDashBoardCR";
	public static final String MAP_TDMONBOARDING_EXPORTFR = "/tdmOnBoardingExportFR";
	public static final String MAP_TDMONBOARDING_EXPORTCR = "/tdmOnBoardingExportCR";
	public static final String MAP_TESTDA_USER = "/testdaUser";
	public static final String MAP_TESTDA_USERBACK = "/testdaUserBack";
	public static final String MAP_TESTDA_SPECILITY = "/testdaSpecility";
	public static final String MAP_TESTDA_SUBSCUSER = "/testdaSubscUser";
	public static final String MAP_TESTDA_SUBSCUSER_BACK = "/testdaSubscUserBack";
	public static final String MAP_TDMNONSTANDARD_SEARCH = "/tdmNonStandardSearch";
	public static final String MAP_TDMNONSTAND_AUTO = "/tdmNonStandAuto";
	public static final String MAP_CANCEL_ONBOARDREQ = "/cancelOnBoardingReq";
	public static final String MAP_CANCEL_MASKINGREQ = "/cancelMaskingReq";
	public static final String MAP_TDM_DATA_MASKING_1_NEW = "/tdmDataMaskingNew";
	public static final String MAP_TDM_DATA_MASKING_2_NEW = "/tdmDataMaskingPage2New";
	public static final String MAP_TDM_DATA_MASKING_3_NEW = "/tdmDataMaskingPage3New";
	public static final String MAP_TDM_DATA_MASKING_3_NEW_EXPORT = "/tdmDataMaskingPage3NewExport";
	public static final String MAP_DATA_MASKING_3_CANCEL = "/tdmDataMaskingPage3Cancel";
	public static final String MAP_MYRESERVATIONS = "/myReservationRecords";
	public static final String MAP_UNRESERVE = "/unReserveRecords";
	public static final String MAP_GET_DEPENDENT_DETAILS = "/getDepenDetails";
	public static final String TDM_ONBOARD_REQ_DEL_ROW = "/tdmOnboardReqDelRow";
	public static final String TDM_DATA_MASKING_3_DEL_ROW = "/tdmDataMaskingPage3DelRow";

	// Model Attributes
	public static final String MODEL_AUTOEMAIL_DTO = "autoEmailDTO";
	public static final String MODEL_FORGOTPASSWORD_DTO = "forgotPasswordDto";
	public static final String MODEL_TDG_DATAMASKING_DTO = "tdgDataMaskingDTO";
	public static final String MODEL_TDG_DATAMASK_REQLISTDTO = "tdgDtMaskRequestListDTOs";
	public static final String MODEL_USERDO = "userdo";
	public static final String MODEL_TDM_CHANGEREQ_DTO = "tdmChangeReqDTO";
	public static final String MODEL_TDM_CLAIMSEARCH_DTO = "tDMClaimSearchDTO";
	public static final String MODEL_TDGDATA_SUBSETTING_DTO = "tdgDataSubsettingDTO";
	public static final String MODEL_TDM_CHANGEMGMT_DTO = "tdgChangeMgmtDTO";
	public static final String MODEL_TDM_DATAREFRESH_DTO = "tdgDataRefreshDTO";
	public static final String MODEL_TDG_TESTDATAREQ_DTO = "tdgTestDataRequestDTO";
	public static final String MODEL_TDMNON_STANDARDSEARCH_DTO = "tdmNonStandSearchDTO";
	public static final String MODEL_DEPENDENT_DETAILS_DTO = "dependentDetailsDTO";
	public static final String MODEL_TDM_ONBORAD_REQDTO = "tdmOnboardReqDTO";
	public static final String MODEL_TDM_PROVSEARCH_DTO = "tDMProvSearchDTO";
	public static final String MODEL_TDM_SUBSCSEARCH_DTO = "tDMSubscSearchDTO";
	public static final String MODEL_TDM_DATA_MASKING_DTOS = "tdgDataMaskingDTOs";
	public static final String TDM_NONSTAND_DTOLIST = "tdmNonStandResrvationDTOList";
	public static final String TDM_NONSTAND_RESULTDTOLIST = "tdmNonStandardSrchResultListDTOs";
	public static final String TDM_NONSTAND_SEARCHDTOLIST = "tdmNonStandSearchDTOList";
	// Services
	public static final String SEARCH_MGMT_SERVICE = "searchManagementService";
	public static final String DATAMASKING_SERVICE = "dataMaskingService";
	public static final String TDM_ADMIN_SERVICE = "tDMAdminService";
	public static final String NONSTAND_SEARCH_MGMT_SERVICE = "nonStandsearchManagementService";
	public static final String EMAIL_NOTIFICATION_SERVICE = "emailNotificationService";

	// Components
	public static final String NONSTANDSRCH_DAOIMPL = "nonStandsearchImplDao";
	public static final String ADMIN_DAO = "tDMAdminDAO";
	public static final String DATAMSKING_DAOIMPL = "tDGDataMaskingDAO";

	// Persistence unit
	public static final String USER_UNIT = "userPersistenceUnit";
	public static final String DTMASKING_UNIT = "dataMaskingPersistenceUnit";
	public static final String SUBSCR_UNIT = "subscPersistenceUnit";

	// Redirections
	public static final String REDIRCT_ACCESSDENIED = "login:redirect?accessDenied=true";
	public static final String REDIRECT_TESTDA_ADMIN = "redirect:testdaAdmin";
	public static final String REDIRECT_ONBOARDREQ = "redirect:tdmOnboardReq?reqId=";
	public static final String REDIRECT_GETDTMASK_REQDTLS = "redirect:tdmDataMaskingNew?reqId=";
	public static final String REDIRECT_TESTDA_CLAIMUSER = "redirect:testdaClaimUser";
	public static final String REDIRECT_TESTDA_USER = "redirect:testdaUser";
	public static final String REDIRECT_TESTDA_SUBSCUSER = "redirect:testdaSubscUser";
	public static final String TDM_DATA_MASKING_PAGE1_REDIRECT = "redirect:tdmDataMaskingNew?reqId=";
	public static final String TDM_DATA_MASKING_PAGE2_REDIRECT = "redirect:tdmDataMaskingPage2New?reqId=";
	public static final String TDM_DATA_MASKING_PAGE3_REDIRECT = "redirect:tdmDataMaskingPage3New?reqId=";

	// JSP pages
	public static final String EMAIL_POPUP = "popupEmail";
	public static final String LOGIN = "login";
	public static final String FORGOT_PASSWORD = "forgotPassword";
	public static final String ADMIN = "admin";
	public static final String INDEX = "index";
	public static final String INDEX_COMMAND_CENTER = "indexCommandCenter";
	public static final String TDM_TRAINING = "tdmTraining";
	public static final String TDM_DATAMASKING_DASHBOARD = "tdmDtMaskDashBoard";
	public static final String TDM_DATAMASKING_DASHBOARD_CR = "tdmDtMaskDashBoardCR";
	public static final String TDM_DATAMASKING = "tdmDataMasking";
	public static final String DISPLAY_USERS = "displayUsers";
	public static final String DISPLAY_USERS_NEW = "displayUsersNew";
	public static final String TDM_DATAMASKING_PAGE2 = "tdmDataMaskingPage2";
	public static final String TDM_DATAMASKING_PAGE3 = "tdmDataMaskingPage3";
	public static final String CREATE_NEW_USER = "createNewUser";
	public static final String TDM_CHANGE_REQEXT = "tdmChangeReqExt";
	public static final String FIND_TESTCLAIM_DATA = "findTestClaimData";
	public static final String TDM_CMDCENTER_METRICS = "tdmCmdCenterMetrics";
	public static final String TDM_DATA_SUBSETTING = "tdmDataSubsetting";
	public static final String TDM_CHANGE_MANAGEMENT = "tdmChangeMgmt";
	public static final String TDM_DATAREFRESH = "tdmDataRefresh";
	public static final String TDM_TESTDATA_REQ = "tdmTestDataRequest";
	public static final String TDM_ESTIMATIONTOOL = "tdmEstimationTool";
	public static final String TDP_ESTIMATIONTOOL = "tdpEstimationTool";
	public static final String TDP_SESITIVE_PROFILER = "sensitivityProfiler";
	public static final String INDEX_GOVERNENCE = "indexGovernence";
	public static final String TDM_GOVBLUEBOOK = "tdmGovBlueBook";
	public static final String RESERVATION_PROVIDER = "reservationProvider";
	public static final String RESERVATION_SUBSCRIPTION = "reservationSubsc";
	public static final String RESERVATION_CLAIM = "reservationClaim";
	public static final String RESERVATION_NS = "reservationNS";
	public static final String TDM_NONSTANDARD_SEARCH = "tdmNonStandardSearch";
	public static final String FINDTEST_NONSTANDARD_DATA = "findTestNonStandardData";
	public static final String TDM_ONBOARDING_REQ = "tdmOnboardReq";
	public static final String TDM_ONBOARDING_DASHBOARD = "tdmOnBoardingDashBoard";
	public static final String TDM_ONBOARDING_DASHBOARDCR = "tdmOnBoardingDashBoardCR";
	public static final String FIND_TESTDATA = "findTestData";
	public static final String FIND_TESTSUBSCRIPTION_DATA = "findTestSubscData";
	public static final String MY_RESERVATIONS = "myReservations";
	public static final String TDM_DATA_MASKING_1_NEW_VIEW = "tdmDataMaskingNew";
	public static final String TDM_DATA_MASKING_2_NEW_VIEW = "tdmDataMaskingPage2New";
	public static final String TDM_DATA_MASKING_3_NEW_VIEW = "tdmDataMaskingPage3New";
	public static final String DEPENDENT_DETAILSVIEW = "dependentDetails";

	public static final String TDM_DATA_MASKING_DASH_BOARD_XLS = "dataMaskingDashBoardExcel";
	public static final String TDM_NONSTAND_RESRVATION_XLS = "tdmNonStandResrvationListExcel";
	public static final String TDM_NONSTAND_SERCHRESULT_XLS = "tdmNonStandSearchResultExcel";

	public static final String AUTO_EMAIL_ID = "sridhar_reddy_gudipati@bcbsil.com";

	// File downloads
	public static final String FILE_USER_MANUAL = "/downloads/UserManual_TDMPortal_InitialDraft.zip";
	public static final String FILE_METRICS_DATATEMPLATE = "/downloads/MetricsDataGatheringtemplate.zip";
	public static final String FILE_TDP_ESTIMATION_TOOL = "/downloads/TDPEstimationTool.7z";
	public static final String FILE_TDM_ESTIMATION_TOOL = "/downloads/TDMEstimationModel.7z";
	public static final String FILE_BLUEBOOK = "/downloads/TestDataManagement_BlueBook v 9.0.docx.zip";
	public static final String ATTACHMENT = "attachment; filename=\"%s\"";

	// Database tables
	public static final String REQ_CH_TABLE = "REQ_CH";
	public static final String REQUESTOR_TABLE = "REQUESTOR";
	public static final String CLAIM_TYPE_DETAILS_TABLE = "CLAIM_TYPE_DETAILS";
	public static final String LIST_VALUE_LKP_TABLE = "LIST_VALUE_LKP";
	public static final String TDM_ONBOAD_REQ_NO_TABS_TABLE = "TDM_ONBOAD_REQ_NO_TABS";
	public static final String TDM_ONBOARD_REQ_TABLE = "TDM_ONBOARD_REQ";
	public static final String RESERVATION_TABLE = "RESERVATION";
	public static final String TDM_USERS_TABLE = "TDM_USERS";
	public static final String TDM_USERS_AUTH_TABLE = "TDM_USERS_AUTH";
	public static final String TDM_LOGIN_USERS_TABLE = "TDMPORTAL_LOGIN_USERS";

	/*
	 * public static final String SUBSCRIBER_DETAILS_TABLE =
	 * "SBUSCRIBER_DETAILS_TEMP"; public static final String
	 * DEPENDENT_DETAILS_TABLE = "DEPENDENT_DETAILS_TEMP"; public static final
	 * String BLENDED_MEMBER_TABLE = "BLENDED_MEMBER_TEMP"; public static final
	 * String MCG_DETAILS_TABLE = "MCG_DETAILS_TEMP";
	 */

	public static final String SUBSCRIBER_DETAILS_TABLE = "SBUSCRIBER_DETAILS";
	public static final String DEPENDENT_DETAILS_TABLE = "DEPENDENT_DETAILS";
	public static final String BLENDED_MEMBER_TABLE = "BLENDED_MEMBER";
	public static final String MCG_DETAILS_TABLE = "MCG_DETAILS";

	public static final String READONLY = "readOnly";
	public static final String NUM_OF_PAGES = "noOfPages";
	public static final String TOTAL_RECORDS = "totalRecords";
	public static final String RESULT = "result";
	public static final String COUNT = "count";
	public static final String PAGE = "page";
	public static final String RESERVE_FLAG = "reserveFlag";
	public static final String START_PAGE = "startPage";
	public static final String LAST_PAGE = "lastPage";
	public static final String CURRENT_PAGE = "currentPage";
	public static final String UNRESEVVE_COUNT = "unResCount";
	public static final String RESERVED_ONLY = "reservedOnly";

	public static final String COMMA = ",";

	public static final String USER_ID = "UserId";
	public static final String USER_NAME = "UserName";
	public static final String RESERVE_ID = "reserveId";
	public static final String PROJECT_ID = "projectId";
	public static final String USER = "user";
	public static final String LOGOUT = "logout";
	public static final String TRUE = "true";
	public static final String FALSE = "false";
	public static final String BACK = "back";
	public static final String READ_BACK = "readBack";
	public static final String EDIT = "edit";
	public static final String IS_CHANGE_REQ = "changeReqYN";
	public static final String EXPORT = "export";
	public static final String REQ_ID = "reqId";
	public static final String _ID = "id";
	public static final String _ON = "ON";
	public static final String _DM = "DM";
	public static final String ITEM_TYPE = "itemType";
	public static final String STATUS = "status";
	public static final String SUBMIT = "submit";
	public static final String DISABLED = "disabled";
	public static final String SAVE_AND_CONTI = "Save and Continue";
	public static final String TDM_DATA_MASKING_PARAM_STS = "&status=";

	public static final String MIME_MAPPING = "application/octet-stream";
	public static final String HEADER_KEY = "Content-Disposition";

	public static final String FR = "FR";
	public static final String CR = "CR"; // Change Request
	public static final String MR = "MR"; // Masking Request
	public static final String TR = "TD"; // TDM on boarding Request
	public static final String PROV = "PROV"; // Provisioning
	public static final String CLM = "CLM"; // Claiming
	public static final String SUB = "SUB"; // Subscription
	public static final String STATUS_SUBMITTED = "Submitted";
	public static final String STATUS_FAILED = "FAILED";
	public static final String STATUS_SUCCESS = "SUCCESS";
	public static final String STATUS_CANCELLED = "Cancelled";
	public static final String C = "C";
	public static final String OPEN = "Open";
	public static final String SHOW = "show";
	public static final String SEARCH_FIELDS = "searchFields";
	public static final String BUTTON = "Button";
	public static final String BUTTON_TEXT = "Create User";
	public static final String UPDATE_BTN_TEXT = "Update User";
	public static final String AC_NAME = "acName";
	public static final String AC_NUM = "acNum";
	public static final String SUBSC_ID = "subscID";
	public static final String ANY = "Any";
	public static final String ALL = "ALL";
	public static final String NULL = "null";
	public static final String ID_EXIST = " User id is already exist";
	public static final String ROLE = "ROLE";
	public static final String ROLE_ADMIN = "ROLE_ADMIN";
	public static final String ROLE_USER = "ROLE_USER";
	public static final String EMAIL_ID = "EMAIL";
	public static final String TDM_BAM_TESTER = "TDM_BAM_Tester";
	public static final String TDM_SECURITY_ADMIN = "TDM_SecurityAdmin";
	public static final String TDM_SUPER_USER = "TDM_SuperUser";
	public static final String LDAP_MAIL = "mail";
	public static final String LDAP_DISPLAY_NAME = "displayName";
	public static final String LDAP_MEMBEROF = "memberOf";

	public static final String PLAN_TYPE = "PLAN TYPE";
	public static final String CLAIM_TYPE = "CLAIM TYPE";
	public static final String MEM_CATEGORY = "MEMBER CATEGORY";
	public static final String COVERAGE_TYPE = "COVERAGE TYPE";
	public static final String MEM_STATUS = "MEMBER STATUS";
	public static final String STATE = "STATE";
	public static final String SUBSCR_RELATION = "SUBSCRIBER RELATIOSHIP";
	public static final String AGE_GROUP = "AGE GROUP";
	public static final String RETAIL = "Retail";
	public static final String ONEXCHANGE = "On-exchange";
	public static final String OFFEXCHANGE = "Off-exchange";
	public static final String SUBSCRIBER_ONLY = "Subscriber Only";
	public static final String STUDENT = "Student";
	public static final String SUB_STUDENT = "Subscriber and Student";
	public static final String SUB_SPOUSE_DEP = "Subscriber, Spouse and Dependent(s)";
	public static final String SUB_SPOUSE = "Subscriber and Spouse";
	public static final String SUB_DEPS = "Subscriber and Dependent(s)";
	public static final String MEDICAL = "Medical";
	public static final String DENTAL = "Dental";
	public static final String VISION = "Vision";
	public static final String BLENDED = "Blended";
	public static final String PRESCRIPTION = "Prescription";
	public static final String PRESCRIPTION_RX = "Prescription(Rx)";
	public static final String RX = "Rx";
	public static final String SUB_ACTIVE = "Subscriber - Active";
	public static final String SUB_CANCELED = "Subscriber - Cancelled";
	public static final String SUB_ACTIV_ACTV_DPEN = "Subscriber - Active with Active Dependent(s)";
	public static final String SUB_ACTIV_CANCEL_DEPN = "Subscriber - Active with Cancelled Dependent";
	public static final String GROUP = "Group";
	public static final String PPO = "PPO";
	public static final String MALE = "Male";
	public static final String FEMALE = "Female";
	public static final String STATE_MT = "Montana(MT)";
	public static final String STATE_NM = "New Mexico(NM)";
	public static final String STATE_OK = "Oklahoma(OK)";
	public static final String STATE_TX = "Texas(TX)";
	public static final String STATE_IL = "Illinois(IL)";

	public static final String MM_DD_YYYY = "MM/dd/yyyy";
	public static final String DD_MM_YYYY = "dd/MM/yyyy";
	public static final String DDMMYYYY_HHMMSS = "dd-MM-yyyy hh:mm:ss a zzz";
	public static final String dd_MM_yyyy = "dd-MM-yyyy";

	public static final String MAPPER_DMASK = "tdmDataMaskingMapper";
	public static final String RESRVE_SUCC = "  Record(s) reserved successfully for Test Case ID: ";
	public static final String RESRVE_SUCC1 = "  and Test Case Name: ";
	public static final String UN_RESRVE_SUCC = "  Record(s) Unreserved successfully. ";

	public static final String ERROR_MESSAGE = "Exception Occurred Contact Admin!!!";
	public static final String ERROR = "error";
	public static final String NO_RECORDS = "No Records found";

	public static final String TDMP_SERVICE_ERROR_11 = "TDMP_SERVICE_ERROR_11";
	public static final String TDMP_SERVICE_ERROR_12 = "TDMP_SERVICE_ERROR12";
	public static final String TDMP_SERVICE_ERROR_13 = "TDMP_SERVICE_ERROR_13";
	public static final String TDMP_SERVICE_ERROR_14 = "TDMP_SERVICE_ERROR_14";
	public static final String TDMP_SERVICE_ERROR_15 = "TDMP_SERVICE_ERROR_15";
	public static final String TDMP_SERVICE_ERROR_16 = "TDMP_SERVICE_ERROR_16";
	public static final String TDMP_SERVICE_ERROR_17 = "TDMP_SERVICE_ERROR_17";
	public static final String TDMP_SERVICE_ERROR_18 = "TDMP_SERVICE_ERROR_18";
	public static final String TDMP_SERVICE_ERROR_19 = "TDMP_SERVICE_ERROR_19";
	public static final String TDMP_SERVICE_ERROR_20 = "TDMP_SERVICE_ERROR_20";
	public static final String TDMP_SERVICE_ERROR_21 = "TDMP_SERVICE_ERROR_21";
	public static final String TDMP_SERVICE_ERROR_22 = "TDMP_SERVICE_ERROR_22";
	public static final String TDMP_SERVICE_ERROR_23 = "TDMP_SERVICE_ERROR_23";
	public static final String TDMP_SERVICE_ERROR_24 = "TDMP_SERVICE_ERROR_24";

	public static final String TDMP_VIEW_ERROR_1 = "TDMP_VIEW_ERROR_1";
	public static final String TDMP_VIEW_ERROR_2 = "TDMP_VIEW_ERROR_2";
	public static final String TDMP_VIEW_ERROR_3 = "TDMP_VIEW_ERROR_3";
	public static final String TDMP_VIEW_ERROR_4 = "TDMP_VIEW_ERROR_4";
	public static final String TDMP_VIEW_ERROR_5 = "TDMP_VIEW_ERROR_5";

}
