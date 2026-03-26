**trigger**:
A trigger in PL/SQL is a stored program that automatically executes when a specific event occurs in the database.

**Types of Triggers:**
PL/SQL triggers are categorized based on timing, event, and level.
1. Based on Timing
   * BEFORE Triggers – Fired before the event (INSERT, UPDATE, DELETE).
   * AFTER Triggers – Fired after the event. 
   * INSTEAD OF Triggers – Used with views to replace the event execution.

2. Based on Event
   * DML Triggers – Fired on INSERT, UPDATE, DELETE.
   * DDL Triggers – Fired on CREATE, ALTER, DROP.
   * Database Event Triggers – Fired on LOGON, LOGOFF, STARTUP, SHUTDOWN.

3. Based on Level
   * Row-Level Triggers – Fired for each row affected.
   * Statement-Level Triggers – Fired once per statement, regardless of row count.

https://www.linkedin.com/pulse/plsql-triggers-comprehensive-guide-eugene-koshy-rgs3c/

**type & rowtype:**
%TYPE - Defines a variable based on the data type of a specific database column or another variable
%ROWTYPE-  Defines a record variable that represents a full or partial row of a database table

**Cursor:**
A PL/SQL cursor is a pointer to a dedicated memory area, called the **context area**, that stores the result set of a 
SQL query.
PL/SQL has two main types of cursors:
- Implicit Cursors
  - Implicit cursors are automatically created and managed by the Oracle database engine for all SELECT INTO,  
    INSERT, UPDATE, and DELETE statements. Programmers do not explicitly declare or control these cursors, but they  
    can access information about the most recent one using the SQL cursor attributes:
    - SQL%FOUND: Returns TRUE if the most recent operation affected one or more rows. 
    - SQL%NOTFOUND: The logical opposite of SQL%FOUND; returns TRUE if no rows were affected.
    - SQL%ISOPEN: Always returns FALSE for implicit cursors because Oracle automatically closes them after execution.
    - SQL%ROWCOUNT: Returns the number of rows affected by the DML statement or returned by the SELECT INTO statement.
  
- Explicit Cursors
  - Explicit cursors are user-defined and managed by the programmer to gain more control over queries
  - Their lifecycle involves four main steps:
    - Declaration:
    - Opening:
    - Fetching:
    - Closing:
    ```SQL
    CURSOR cursor_name IS select_statement;
    OPEN cursor_name;
    FETCH cursor_name INTO variable_list;
    CLOSE cursor_name;
    ```

- Cursor FOR Loops 
  - A common and more efficient way to work with explicit cursors is using the cursor FOR loop. 
  - This loop implicitly handles the OPEN, FETCH, EXIT WHEN %NOTFOUND, and CLOSE operations, making the code cleaner
    ```SQL
    FOR record_name IN cursor_name LOOP
        -- process the record
    END LOOP;
    ```

- Cursor Variables (REF CURSOR)
  - Cursor variables (of type REF CURSOR) are pointers to a result set that can be passed between different PL/SQL 
    blocks or between PL/SQL and host environments like Java. 
  - This provides flexibility, as the query associated with the cursor variable can be determined at runtime.