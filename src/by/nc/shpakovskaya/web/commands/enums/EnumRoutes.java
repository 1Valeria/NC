package by.nc.shpakovskaya.web.commands.enums;

import by.nc.shpakovskaya.web.commands.ActionCommand;
import by.nc.shpakovskaya.web.commands.inner.*;

/**
 * Created by Valeria on 13.11.2016.
 */
public enum EnumRoutes {

    MAIN{
        {
            this.command = new MainCommand();
        }
    },
    ENTER {
        {
            this.command = new EnterCommand();
        }
    },
    PERSONAL {
        {
            this.command = new PersonalCommand();
        }
    },
    CHOOSE_REGISTRATION {
        {
            this.command = new ChooseRegistrationCommand();
        }
    },
    REGISTRATION {
        {
            this.command = new RegistrationCommand();
        }
    },
    REGISTRATION_DOCTOR {
        {
            this.command = new RegistrationDoctorCommand();
        }
    },
    SUBMIT_USER {
        {
            this.command = new SubmitUserRegistrationCommand();
        }
    },
    SUBMIT_DOCTOR {
        {
            this.command = new SubmitDoctorRegistrationCommand();
        }
    },
    ACCEPT_REQUESTS {
        {
            this.command = new AcceptRequestsCommand();
        }
    },
    ADD_DEPARTMENT {
        {
            this.command = new AddDepartmentCommand();
        }
    },
    DEPARTMENT_ADDED {
        {
            this.command = new DepartmentAddedCommand();
        }
    },
    ADD_HOSPITAL {
        {
            this.command = new AddHospitalCommand();
        }
    },
    HOSPITAL_ADDED {
        {
            this.command = new HospitalAddedCommand();
        }
    },
    LOGOUT {
        {
            this.command = new LogoutCommand();
        }
    };


    ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }

}
