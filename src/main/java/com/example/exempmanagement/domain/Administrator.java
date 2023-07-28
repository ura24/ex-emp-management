package com.example.exempmanagement.domain;

public class Administrator {
    /**ID */
    private Integer id;
    /**名前 */
    private String name;
    /**メールアドレス */
    private String mailAddress;
    /**パスワード */
    private String password;

    /**
     * 引数なしコンストラクタ
     */
    public Administrator() {};

    /**
     * 引数ありコンストラクタ
     * @param id
     * @param name
     * @param mailAddress
     * @param password
     */
    public Administrator(Integer id, String name, String mailAddress, String password) {
        this.id = id;
        this.name = name;
        this.mailAddress = mailAddress;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getMailAddress() {
        return mailAddress;
    }
    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
