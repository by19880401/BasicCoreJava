package mockprivate;

public class DemoPrivate {

    public String publicFunc(Long param) {
        return privateFunc() + privateFuncWithParams(param);
    }

    private String privateFunc() {
        return "private func";
    }

    private String privateFuncWithParams(Long param) {
        return "private func, param:" + param;
    }
}
