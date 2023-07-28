package com.example.exempmanagement.domain;

import java.util.Date;

public class Employee {
    /**ID */
    private Integer id;
    /**名前 */
    private String name;
    /**画像 */
    private String image;
    /**性別 */
    private String gender;
    /**入社日 */
    private Date hireDate;
    /**メールアドレス */
    private String mailAddress;
    /**郵便番号 */
    private String zipCode;
    /**住所 */
    private String address;
    /**電話番号 */
    private String telephone;
    /**給料 */
    private Integer salaly;
    /**特製 */
    private String characteristics;
    /**扶養人数 */
    private Integer dependentsCount;

    /**
     * 引数なしコンストラクタ
     */
    public Employee() {}

    /**
     * 引数ありコンストラクタ
     * @param id
     * @param name
     * @param image
     * @param gender
     * @param hireDate
     * @param mailAddress
     * @param zipCode
     * @param address
     * @param telephone
     * @param salaly
     * @param characteristics
     * @param dependentsCount
     */
    public Employee(Integer id, String name, String image, String gender, Date hireDate, String mailAddress,
            String zipCode, String address, String telephone, Integer salaly, String characteristics,
            Integer dependentsCount) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.gender = gender;
        this.hireDate = hireDate;
        this.mailAddress = mailAddress;
        this.zipCode = zipCode;
        this.address = address;
        this.telephone = telephone;
        this.salaly = salaly;
        this.characteristics = characteristics;
        this.dependentsCount = dependentsCount;
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
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public Date getHireDate() {
        return hireDate;
    }
    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }
    public String getMailAddress() {
        return mailAddress;
    }
    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }
    public String getZipCode() {
        return zipCode;
    }
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getTelephone() {
        return telephone;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    public Integer getSalaly() {
        return salaly;
    }
    public void setSalaly(Integer salaly) {
        this.salaly = salaly;
    }
    public String getCharacteristics() {
        return characteristics;
    }
    public void setCharacteristics(String characteristics) {
        this.characteristics = characteristics;
    }
    public Integer getDependentsCount() {
        return dependentsCount;
    }
    public void setDependentsCount(Integer dependentsCount) {
        this.dependentsCount = dependentsCount;
    }

    
}
