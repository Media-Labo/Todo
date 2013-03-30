package jp.co.media_labo.android.todo.entities;

import java.util.Date;

/**
 * ToDoの情報を保持するクラスです。
 * このクラスは不変(イミュータブル)です。
 * @author tanabe
 *
 */
public class TodoEntity {

    /** ID */
    private int id;

    /** 概要 */
    private String summary;

    /** 詳細 */
    private String detail;

    /** 状態 */
    private TodoStatus status;

    /** 重み */
    private int weight;

    /** 作成日 */
    private Date createDate;

    /** 開始日 */
    private Date startDate;

    /** 終了日 */
    private Date endDate;

    /**
     * ToDo情報を生成します。
     * @param id 識別用ID
     * @param summary 概要
     * @param detail 詳細
     * @param status 状態
     * @param weight 重み
     * @param createDate 作成日
     * @param startDate 開始日
     * @param endDate 終了日
     * @throws IllegalArgumentException 設定不可の値が渡された場合
     */
    private TodoEntity(
        int        id,
        String     summary,
        String     detail,
        TodoStatus status,
        int        weight,
        Date       createDate,
        Date       startDate,
        Date       endDate )
    {
        try {
            this.setId(id);
            this.setSummary(summary);
            this.setDetail(detail);
            this.setStatus(status);
            this.setWeight(weight);
            this.setCreateDate(createDate);
            this.setStartDate(startDate);
            this.setEndDate(endDate);
        }
        catch( Exception e ) {
            throw new IllegalArgumentException( "引数が不正", e );
        }
    }

    /**
     * @param id セットする id
     * @throws IllegalArgumentException 引数が負の場合
     */
    private void setId(int id) {
        if( id < 0 ) {
            throw new IllegalArgumentException( "idは負不可[" + id + "]" );
        }
        this.id = id;
    }

    /**
     * @param summary セットする summary
     * @throws NullPointerException 引数がnullの場合
     * @throws IllegalArgumentException 引数が空文字の場合
     */
    private void setSummary(String summary) {
        if( summary == null ) {
            throw new NullPointerException( "summaryはnull不可" );
        }
        if( summary.isEmpty() ) {
            throw new IllegalArgumentException( "summaryは空文字不可" );
        }
        this.summary = summary;
    }

    /**
     * @param detail セットする detail
     * @throws NullPointerException 引数がnullの場合
     */
    private void setDetail(String detail) {
        if( detail == null ) {
            throw new NullPointerException( "detailはnull不可" );
        }
        this.detail = detail;
    }

    /**
     * @param status セットする status
     * @throws NullPointerException 引数がnullの場合
     */
    private void setStatus(TodoStatus status) {
        if( status == null ) {
            throw new NullPointerException( "statusはnull不可" );
        }
        this.status = status;
    }

    /**
     * @param weight セットする weight
     * @throws IllegalArgumentException 引数が負の場合
     */
    private void setWeight(int weight) {
        if( weight < 0 ) {
            throw new IllegalArgumentException( "weightは負不可" );
        }
        this.weight = weight;
    }

    /**
     * @param createDate セットする createDate
     * @throws NullPointerException 引数がnullの場合
     */
    private void setCreateDate(Date createDate) {
        if( createDate == null ) {
            throw new NullPointerException( "createDateはnull不可" );
        }
        this.createDate = (Date)createDate.clone();
    }

    /**
     * @param startDate セットする startDate
     * @throws NullPointerException 引数がnullの場合
     */
    private void setStartDate(Date startDate) {
        if( startDate == null ) {
            throw new NullPointerException( "startDateはnull不可" );
        }
        this.startDate = (Date)startDate.clone();
    }

    /**
     * @param endDate セットする endDate
     * @throws NullPointerException 引数がnullの場合
     */
    private void setEndDate(Date endDate) {
        if( endDate == null ) {
            throw new NullPointerException( "endDateはnull不可" );
        }
        this.endDate = (Date)endDate.clone();
    }

    /**
     * IDを取得します。
     * @return id ID
     */
    public int getId() {
        return id;
    }

    /**
     * 概要を取得します。
     * @return summary 概要
     */
    public String getSummary() {
        return summary;
    }

    /**
     * 詳細を取得します。
     * @return detail 詳細
     */
    public String getDetail() {
        return detail;
    }

    /**
     * 状態を取得します。
     * @return status 状態
     */
    public TodoStatus getStatus() {
        return status;
    }

    /**
     * 重みを取得します。
     * @return weight 重み
     */
    public int getWeight() {
        return weight;
    }

    /**
     * 生成日を取得します。
     * @return createDate 生成日
     */
    public Date getCreateDate() {
        return (Date)createDate.clone();
    }

    /**
     * 開始日を取得します。
     * @return startDate 開始日
     */
    public Date getStartDate() {
        return (Date)startDate.clone();
    }

    /**
     * 終了日を取得します。
     * @return endDate 終了日
     */
    public Date getEndDate() {
        return (Date)endDate.clone();
    }


    /**
     * ToDo情報を生成するクラスです。
     * @author tanabe
     *
     */
    public static class TodoEntityBuilder {

        private int         id         = -1;
        private String      summary    = "";
        private String      detail     = "";
        private TodoStatus  status     = TodoStatus.CREATED;
        private int         weight     = -1;
        private Date        createDate = null;
        private Date        startDate  = null;
        private Date        endDate    = null;

        /**
         * @param id セットする id
         */
        public TodoEntityBuilder setId(int id) {
            this.id = id;
            return this;
        }

        /**
         * @param summary セットする summary
         */
        public TodoEntityBuilder setSummary(String summary) {
            this.summary = summary;
            return this;
        }

        /**
         * @param detail セットする detail
         */
        public TodoEntityBuilder setDetail(String detail) {
            this.detail = detail;
            return this;
        }

        /**
         * @param status セットする status
         */
        public TodoEntityBuilder setStatus(TodoStatus status) {
            this.status = status;
            return this;
        }

        /**
         * @param weight セットする weight
         */
        public TodoEntityBuilder setWeight(int weight) {
            this.weight = weight;
            return this;
        }

        /**
         * @param createDate セットする createDate
         */
        public TodoEntityBuilder setCreateDate(Date createDate) {
            this.createDate = createDate;
            return this;
        }

        /**
         * @param startDate セットする startDate
         */
        public TodoEntityBuilder setStartDate(Date startDate) {
            this.startDate = startDate;
            return this;
        }

        /**
         * @param endDate セットする endDate
         */
        public TodoEntityBuilder setEndDate(Date endDate) {
            this.endDate = endDate;
            return this;
        }
        
        /**
         * Todo情報を生成します。
         * @return 生成したTodo情報
         * @throws IllegalArgumentException 生成に失敗した場合
         */
        public TodoEntity build() {
            return new TodoEntity(
                    id,
                    summary,
                    detail,
                    status,
                    weight,
                    createDate,
                    startDate,
                    endDate);
        }
    }
}
