package com.maple.web.carserver.domain;

public class QuestionEntity {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_question.id
     *
     * @mbg.generated Wed Mar 28 21:23:26 CST 2018
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_question.question
     *
     * @mbg.generated Wed Mar 28 21:23:26 CST 2018
     */
    private String question;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_question.answer
     *
     * @mbg.generated Wed Mar 28 21:23:26 CST 2018
     */
    private String answer;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_question.id
     *
     * @return the value of tb_question.id
     *
     * @mbg.generated Wed Mar 28 21:23:26 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_question.id
     *
     * @param id the value for tb_question.id
     *
     * @mbg.generated Wed Mar 28 21:23:26 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_question.question
     *
     * @return the value of tb_question.question
     *
     * @mbg.generated Wed Mar 28 21:23:26 CST 2018
     */
    public String getQuestion() {
        return question;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_question.question
     *
     * @param question the value for tb_question.question
     *
     * @mbg.generated Wed Mar 28 21:23:26 CST 2018
     */
    public void setQuestion(String question) {
        this.question = question == null ? null : question.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_question.answer
     *
     * @return the value of tb_question.answer
     *
     * @mbg.generated Wed Mar 28 21:23:26 CST 2018
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_question.answer
     *
     * @param answer the value for tb_question.answer
     *
     * @mbg.generated Wed Mar 28 21:23:26 CST 2018
     */
    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }
}