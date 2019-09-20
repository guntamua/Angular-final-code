import { Component, ViewChild, ViewEncapsulation } from '@angular/core';
import { RadioButtonComponent } from '@syncfusion/ej2-angular-buttons';
import { QueryBuilderComponent, TemplateColumn, ColumnsModel, RuleChangeEventArgs  } from '@syncfusion/ej2-angular-querybuilder';
import { getComponent, createElement, isNullOrUndefined } from '@syncfusion/ej2-base';
import { CheckBox } from '@syncfusion/ej2-buttons';
import { DropDownList } from '@syncfusion/ej2-dropdowns';
import { Slider } from '@syncfusion/ej2-inputs';
import { RuleModel } from '@syncfusion/ej2-querybuilder';
import { expenseData } from '../sample-test/expenseData';

@Component({
  selector: 'app-sample-test',
  templateUrl: './sample-test.component.html',
  styleUrls: ['./sample-test.component.css']
})
export class SampleTestComponent {

  qryBldrObj: QueryBuilderComponent;
    radioButton: RadioButtonComponent;

    displayRule: any = '';
    dataSource = expenseData;

    importRules: RuleModel = {
        'condition': 'and',
        'rules': [{
            'label': 'Category',
            'field': 'Category',
            'type': 'string',
            'operator': 'in',
            'value': ['Clothing']
        },
        {
            'condition': 'or',
            'rules': [{
                'label': 'Transaction Type',
                'field': 'TransactionType',
                'type': 'string',
                'operator': 'equal',
                'value': 'checked'
            },
            {
                'label': 'Payment Mode',
                'field': 'PaymentMode',
                'type': 'string',
                'operator': 'equal',
                'value': 'Cash'
            }]
        }, {
            'label': 'Amount',
            'field': 'Amount',
            'type': 'number',
            'operator': 'equal',
            'value': 10
        }
        ]
    };
updateRule(args: RuleChangeEventArgs ): void {
        if (this.radioButton.checked) {
            this.displayRule = this.qryBldrObj.getSqlFromRules(args.rule);
        } else {
            this.displayRule = JSON.stringify(args.rule, null, 4);
        }
    }
change(): void {
    this.updateRule({rule: this.qryBldrObj.getValidRules(this.qryBldrObj.rule)})
    }


}

