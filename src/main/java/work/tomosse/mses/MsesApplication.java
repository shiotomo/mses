package work.tomosse.mses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import work.tomosse.mses.service.AccountService;

@SpringBootApplication
public class MsesApplication {
    @Autowired
    AccountService accountService;

    public static void main(final String[] args) {
        final var ctx = SpringApplication.run(MsesApplication.class, args);
        final var app = ctx.getBean(MsesApplication.class);
        app.execStartUp(args);
    }

    /**
     * ユーザがいなければADMINユーザを追加する
     *
     * @param args
     */
    public void execStartUp(final String[] args) {
        accountService.createAdmin();
    }

}
