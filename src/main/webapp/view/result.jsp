<%@ page import="dictionary.model.Word" %>


<form action="/translator" method="post">
    <fieldset>
        <legend>Result</legend>
        <input type="hidden" name="id" value="">
        <table>
            <tr>
                <td>
                    ${string}
                </td>
        </table>
    </fieldset>
</form>
<a href="/translator">Back to translator</a>.